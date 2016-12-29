package hashtable;

import java.util.HashSet;

public class _202_HappyNumber {
    
    public boolean isHappy(int n) {
        
        HashSet<Integer> exists = new HashSet<Integer>();
        
        while (n != 1) {
            n = getSquareSum(n);
            
            if (exists.contains(n)) return false;
            exists.add(n);
        }
        
        return true;
    }
    
    private int getSquareSum(int num) {
        
        int sum = 0;
        while (num != 0) {
            sum += Math.pow(num % 10, 2);
            num /= 10;
        }
        return sum;
    }
}
