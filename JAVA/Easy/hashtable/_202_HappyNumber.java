package hashtable;

import java.util.HashSet;

public class _202_HappyNumber {
    
    public boolean isHappy(int n) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            
            if (set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
        
        return true;
        
    }
}
