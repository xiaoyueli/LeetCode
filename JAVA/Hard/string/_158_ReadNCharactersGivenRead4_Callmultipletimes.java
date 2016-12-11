package string;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. 
 * For example, it returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * 
 * Note:
 * The read function may be called multiple times.
 * 
 * 题意：
 * 和157 easy版的区别是，如果本次读取了4个字符但是没有使用完就达到要求的读取数量，那下次再call这个function时，这些被读取却没有使用的字符应该再次被使用。
 * 
 * 思路：
 * 把本次读取却没有使用的字符存入que中
 */

import java.util.LinkedList;
import java.util.Queue;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class _158_ReadNCharactersGivenRead4_Callmultipletimes extends Reader4 {
/**
* @param buf Destination buffer
* @param n   Maximum number of characters to read
* @return    The number of characters read
*/

    Queue<Character> que = new LinkedList<Character>();
    
    public int read(char[] buf, int n) {
      
      int sum = 0;
      
      while (!que.isEmpty() && sum < n) {
          buf[sum++] = que.poll();
      }
      
      char[] cache = new char[4];
    
      while (sum < n) {
          int cnt = read4(cache);
          int i = 0;
          for (; i < cnt && sum < n; i++) {
              buf[sum++] = cache[i];
          }
          
          if (sum == n) for (; i < 4 && i < cnt; i++) que.offer(cache[i]);
          if (cnt < 4) break;
          
      }
    
      return sum;  
    }
}
