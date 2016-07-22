package math;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 */

public class _7_ReverseInteger {
    
    public int reverse(int x) {
        
        long val = x;
        long res = 0;
        
        while (val != 0) {
            res = res * 10 + val % 10;
            if (res >= Integer.MAX_VALUE) return 0;
            else if (res <= Integer.MIN_VALUE) return 0;
            val /= 10;
        }
        
        return (int)res;
    }
}
