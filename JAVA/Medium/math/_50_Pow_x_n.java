package math;

/**
 * Implement pow(x, n).
 *
 */

public class _50_Pow_x_n {
    
    public double myPow(double x, int n) {
    
        if (n == 0) return 1.0;
        long ln = n;
        if (ln < 0) {
            x = 1 / x;
            ln = -ln;
        }

        double res = 1;
        while (ln > 0) {

            if (ln % 2 != 0) res *= x;
            x *= x;
            ln >>= 1;
            
        }        

        return res;
    }
    
    public double myPow1(double x, int n) {
        
        if (n == 0) return 1.0;
        
        double res = 1;
        long leftN = n;
        boolean flag = true;
        if (n < 0) {
            leftN = -leftN;
            flag = false;
        }
        
        while (leftN > 0) {
            
            double temp = x;
            long curN = 1;
            double pre = temp;
            while (curN <= leftN) {
                pre = temp;
                temp *= temp;
                curN <<= 1;
            }
            
            res *= pre;
            leftN -= curN >> 1;
        }
        
        if (!flag) res = 1 / res;
        
        return res;
    }
    
    public double myPow2(double x, int n) {
        
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        
        int half = n >> 1;
        
        double res = myPow2(x, half) ;
        if (n % 2 == 0) res *= res;
        else res *= res * x;

        return res;
    }

}
