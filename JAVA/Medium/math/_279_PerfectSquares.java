package math;

/**
 * Given a positive integer n, find the least number of perfect square numbers 
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; 
 * given n = 13, return 2 because 13 = 4 + 9.
 * 
 * 用一个数组来记录组成 1 - n 的最小平方数数量
 * 如果某个小于n的平方数为i * i
 * 则组成n 包括i * i 时的最小平方数数量就 == n - i * i 这个数的最小平方数数量 + 1
 *  以此递推从1开始遍历，求n
 */

public class _279_PerfectSquares {
    
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int[] counts = new int[n + 1];
        
        
        for (int num = 1; num <= n; num++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i * i <= num; i++) {
                int val = counts[num - i * i] + 1;
                if (min > val) min = val;
            }
            counts[num] = min;
        }
        
        return counts[n];
    }

}
