package math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * 计算N的阶乘末尾0的个数
 * 0的个数有N的阶乘各数的质因子2 和 5 的对数决定
 * 质因子2的个数一定大于5
 * 因此有5的个数决定
 * 
 * 可观察 15！ 质因子5的个数由 5，10, 15提供: 15 / 5 = 3
 *       25！ 质因子5的个数由5， 10， 15, 20， 25提供: 即 25 / 5 = 5
 *       25 由于 5 * 5 因此多一个5
 *       所以商作为被除数需再除以5，直到被除数为0；
 */

public class _172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        
        int res = 0;
        
        while (n / 5 != 0) {
            n /= 5;
            res += n;
        }
        
        return res;
    }
}
