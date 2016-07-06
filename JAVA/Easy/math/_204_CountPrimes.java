package math;

/**
 * 是prime倍数的数都不是prime
 */

public class _204_CountPrimes {
    
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int cnt = 0;
        for (int num = 2; num < n; num++) {
            if (!notPrime[num]){
                for (int mul = 2 * num; mul < n; mul += num) notPrime[mul] = true;
                cnt++;
            }
        }
        
        return cnt;
    }
}
