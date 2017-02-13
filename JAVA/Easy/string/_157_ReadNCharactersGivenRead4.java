package string;

import string.Reader4;

/**
 * 
 * @author xiaoyue
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. 
 * For example, it returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note:
 * The read function will only be called once for each test case.
 * 
 * 题意：
 * 用API read4读文件。将读到的文件复制到buf中，要求读n个字符，返回实际读到的字符
 * 
 * 重点注意，buf不是数据源，是需要输出的数据。源文件应该在read4 API中，调用这个API后，会将读到的字符保存在传入的参数数组中
 *
 */

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class _157_ReadNCharactersGivenRead4 extends Reader4 {
/**
* @param buf Destination buffer
* @param n   Maximum number of characters to read
* @return    The number of characters read
*/
    public int read(char[] buf, int n) {
      
      int sum = 0;
      char[] cache = new char[4];
      
      while (sum < n) {
          int cnt = read4(cache);
          
          for (int i = 0; i < cnt && sum < n; i++) {
              buf[sum++] = cache[i];
          }
          
          if (cnt < 4) break;
          
      }
      
      return sum;
    
      
    }
}
