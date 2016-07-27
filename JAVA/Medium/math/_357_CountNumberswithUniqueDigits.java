package math;

/**
 * Given a non-negative integer n, 
 * count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * 
 * Example:
 * Given n = 2, return 91. 
 * (The answer should be the total numbers in the range of 0 ≤ x < 100, 
 * excluding [11,22,33,44,55,66,77,88,99])
 * 
 * 求10的N次方内每一位数字都不重复的数的个数
 * 排列组合
 * 首位9种（不含0），第2位也是9种（含0）， 之后依次递减
 *
 */

public class _357_CountNumberswithUniqueDigits {
    
    public int countNumbersWithUniqueDigits(int n) {
        
        if (n == 0) return 1;
        if (n == 1) return 10;
        
        int res = 10; // 各位数字0-9
        int nums = 9; // 首位的取值种类
        int nextdigit = 9; // 第二位的取值种类
        n--;
        while (n > 0 && nextdigit > 0) {
            nums *= nextdigit;
            res += nums; 
            nextdigit--;
            n--;
        }
        
        return res;
    }
}