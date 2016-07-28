package math;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * x的平方根不大于 X/2 + 1
 *
 */

public class _69_Sqrt_x {
    
    public int mySqrt(int x) {
        
        long ceiling = x / 2 + 1;
        long floor = 0;
        
        while (floor <= ceiling) {
            long mid = (ceiling + floor) / 2;
            long val = mid * mid;
            if (x == val) return (int)mid;
            else if (x > val) floor = mid + 1;
            else ceiling = mid - 1;
        }
        
        return (int)ceiling;
    }
}
