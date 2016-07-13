package math;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * Follow up:
 * Could you do it without using any loop / recursion?
 */

public class _326_PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        return n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
        
        
    }
    
    public boolean isPowerOfThree2(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 3 == 0) return isPowerOfThree(n / 3);
        
        return false;
    }
}
