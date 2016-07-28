package math;

/**
 * Given a positive integer n, 
 * break it into the sum of at least two positive integers and 
 * maximize the product of those integers. Return the maximum product you can get.
 * 
 * For example, 
 * given n = 2, return 1 (2 = 1 + 1); 
 * given n = 10, return 36 (10 = 3 + 3 + 4).
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * 
 * 规律就是任何一个数拆分后的乘积最大值等于尽量多的3 补以2
 *
 */

public class _343_IntegerBreak {
    
    public int integerBreak(int n) {
        
        if (n == 2) return 1;
        if (n == 3) return 2;
        
        int cnt3 = n / 3;
        int rema = n % 3;
        int res = 0;
        if (rema == 0) res = (int)Math.pow(3, cnt3);
        else if (rema == 1) res = (int)Math.pow(3, cnt3 - 1) * 4;
        else res = (int)Math.pow(3, cnt3) * 2;
   
        return res;
    }
}
