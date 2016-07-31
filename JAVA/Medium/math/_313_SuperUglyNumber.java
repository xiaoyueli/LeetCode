package math;

/**
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers 
 * whose all prime factors are in the given prime list primes of size k. 
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
 * is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * 
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 *
 *  两种方法的差异在，第一种建立数组保存每个prime追踪的中间量，第二种每次计算
 */

public class _313_SuperUglyNumber {
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int len = primes.length;
        int[] minPrimes = new int[len];
        
        for (int idx = 0; idx < len; idx++) minPrimes[idx] = 1 * primes[idx];
        
        int[] uNums = new int[n];
        int[] indices = new int[len];
        uNums[0] = 1;
        
        for (int idx = 1; idx < uNums.length; idx++) {
            int min = Integer.MAX_VALUE;
            for (int pIdx = 0; pIdx < len; pIdx++) {
                int val = minPrimes[pIdx];
                if (val < min) min = val;
            }
            
            uNums[idx] = min;
            
            for (int pIdx = 0; pIdx < len; pIdx++) {
                if (min == minPrimes[pIdx]) {
                    
                    indices[pIdx]++;
                    minPrimes[pIdx] = uNums[indices[pIdx]] * primes[pIdx];
    
                }
            }
            
            
        }
        
        return uNums[n - 1];
        
    }
    
    public int nthSuperUglyNumber2(int n, int[] primes) {
        // 原理和uglyNum一样，每次计算各个prime 追踪的最小uglyNum乘以这个Prime的值，取最小
        // 则是下一个uglyNum
        // 然后更新所有乘积为最小值得prime所追踪 的下标到下一个uglyNum
        
        int len = primes.length;
        int[] indices = new int[len];   // 记录每一个prime追踪的最小uglyNum. 和uglyNum2 中的idx2.idx3,idx5功能相同
        int[] uNums = new int[n];       //  记录第i个uglyNum
        uNums[0] = 1;
        
        for (int idx = 1; idx < uNums.length; idx++) {
            int min = Integer.MAX_VALUE;
            for (int pIdx = 0; pIdx < len; pIdx++) {
                int val = uNums[indices[pIdx]] * primes[pIdx];  // 计算每个prime追踪的最小uglyN
                if (val < min) min = val;                       // 其中的最小值为下一个uglyNum
            }
            
            uNums[idx] = min;
            
            for (int pIdx = 0; pIdx < len; pIdx++) {
                //  将是min因子的所有prime追踪的uglyNum更新到下一个
                //  排除乘积已经存在的情况
                //  例如 有prime 2, 4, 当prime 2 已经将最小uglyNum更新到12
                //  而4 追踪的uglyNum是3，即下一次会用3 * 4 == 12 ，作为4追踪的uglyNum
                //  和其他prime追踪的uglyNum 进去比较求最小值，就会出现重复的情况
                //  因此需要将4追踪的uglyNum 更新到下一位
                if (min % primes[pIdx] == 0) indices[pIdx]++;   
            }
 
        }
        
        return uNums[n - 1];
        
    }

    public static void main(String[] args) {
        _313_SuperUglyNumber test = new _313_SuperUglyNumber();
//        test.nthSuperUglyNumber(12, new int[] {2, 7, 13, 19});
        
    }
}
