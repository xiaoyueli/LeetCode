package dynamicProgramming;

/**
 * You are climbing a stair case. 
 * It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 *
 */

public class _70_ClimbingStairs {
    
    public int climbStairs(int n) {
        
        if (n == 0) return 0;
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int idx = 2; idx < n + 1; idx++) {
            ways[idx] = ways[idx - 1] + ways[idx - 2];
        }
        return ways[n];
    }

}
