package math;

/**
 * 
 * Given a positive integer num, write a function which returns True 
 * if num is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * Input: 16
 * Returns: True
 * 
 * Example 2:
 * Input: 14
 * Returns: False
 * 
 * 二分法
 *
 */

public class _367_ValidPerfectSquare {
    
    public boolean isPerfectSquare(int num) {
        
        long right = num / 2 + 1;
        long left = 0;
        
        while (left <= right) {
            long mid = (right + left) / 2;
            long val = mid * mid;
            if (num == val) return true;
            if (num > val) left = mid + 1;
            else right = mid - 1;
        }
        
        return false;
        
    }
}
