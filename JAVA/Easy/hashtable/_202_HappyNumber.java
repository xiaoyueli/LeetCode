package hashtable;

import java.util.HashSet;

public class _202_HappyNumber {
    public boolean isHappy(int n) {
        
        if (n <= 0) return false;
        HashSet<Integer> list = new HashSet<Integer>();
        do {
            if (n < 10) n = (int)Math.pow(n, 2);
            else {
                int sum = 0;
                while (n > 0) {
                    int lastDig = n % 10;
                    sum += (int)Math.pow(lastDig, 2);
                    n /= 10; 
                }
                n = sum;
                if (list.contains(sum)) return false;
                else if (n != 1) list.add(sum);
            }
        } while (n != 1);
        
        return true;
        
    }
}
