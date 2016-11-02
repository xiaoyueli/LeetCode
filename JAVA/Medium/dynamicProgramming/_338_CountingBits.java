package dynamicProgramming;

/**
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num 
 * calculate the number of 1's in their binary representation and return them as an array.
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * 
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? 
 * Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * 
 * 思路：
 * 方法1：
 * 如果是奇数，则1的数量为上一个偶数+1；
 * 如果是pow of 2的数，则1的数量为1
 * 其他偶数，pow of 2的数的和，于是每次遇到新的POW of 2的数，记录下来，然后用当前数 - 新的pow of 2的数，相加他们1的数量即为当前值1得数量
 * 
 * 
 * 方法2：如果一个数是2的倍数，则1的数量和其1/2的值相等
 * 否则为其1/2的值得数量 + 1
 */

public class _338_CountingBits {
    
    public int[] countBits(int num) {
        
        int[] res = new int[num + 1];
        
        int pow = 1;
        for (int i = 1; i <= num; i++){
            if (i % 2 != 0) res[i] = res[i - 1] + 1;
            else {
               if (i % pow == 0) {
                   res[i] = 1;
                   pow = i;
               } 
               else res[i] = res[pow] + res[i - pow];
            }
        }
        
        return res;
        
    }
    
    public int[] countBits1(int num) {
        // 如果一个数是2的倍数，则1的数量和其1/2的值相等
        // 否则为其1/2的值得数量 + 1
        
        int[] res = new int[num + 1];
        
        res[0] = 0;
        if (num >= 1 ) {
            res[1] = 1;
            for (int idx = 2; idx <= num; idx++) {
                res[idx] = res[idx / 2] + res[idx % 2];
            }
        }
        
        return res;
    }
    
}
