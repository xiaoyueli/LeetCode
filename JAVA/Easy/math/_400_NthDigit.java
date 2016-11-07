package math;

/**
 * 
 * @author xiaoyue
 * 
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * 
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * 
 * Example 1:
 * Input:
 * 3
 * 
 * Output:
 * 3
 * 
 * Example 2:
 * Input:
 * 11
 * 
 * Output:
 * 0
 * 
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * 
 * 思路，
 * 1位数 有9个，共9个数
 * 2位数 10 - 99 有 90 个，共 2 * 90 个数字
 * 3位数 100 - 999 有 900 个， 共 3 * 900 个数字
 * 
 * 对n不断做减法，定位n属于哪一位数
 * 然后除以相应的位数，定位n是第一个数，
 * 最后求余，定位是该数字的第几位
 *
 */

public class _400_NthDigit {
    
    public int findNthDigit(int n) {
        
        if (n < 10) return n;
        int len = 1;
        long amount = 9;  // 防止溢出

        while (n > len * amount) {
            n -= (int)(len * amount);
            len++;
            amount *= 10;
            
        }
        
        int numth = (n - 1) / len; // 求是该位数的第几个数
        int digith = (n - 1) % len; // 求是该数的第几个字符，从0开始
        
        int num = (int) Math.pow(10, len - 1) + numth; // 求是哪一个数
        
        char digit = (num + "").charAt(digith);
        
        return digit - '0';
    }

}
