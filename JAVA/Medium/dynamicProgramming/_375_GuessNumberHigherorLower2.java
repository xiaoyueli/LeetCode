package dynamicProgramming;

/**
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * 
 * However, when you guess a particular number x, and you guess wrong, you pay $x. 
 * You win the game when you guess the number I picked.
 * 
 * Example:
 * n = 10, I pick 8.
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * 
 * Game over. 8 is the number I picked.
 * You end up paying $5 + $7 + $9 = $21.
 * 
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 * 
 * Hint:
 * The best strategy to play the game is to minimize the maximum loss you could possibly face. 
 * Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
 * Take a small example (n = 3). What do you end up paying in the worst case?
 * Check out this article if you're still stuck.
 * The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming.
 * As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, instead of the worst-case loss?
 * 
 * 递归+动态规划
 * 在递归的时候存下当前求得的值
 * 
 * 思路：
 * 求一个范围内选取，选取每一个值可能付出的最大代价，再在其中取最小值，就是当前范围所能取胜所需付出的最小代价
 * 
 * @author xiaoyue
 *
 */

public class _375_GuessNumberHigherorLower2 {
    
    public int getMoneyAmount(int n) {
        
        int[][] dp = new int[n + 1][n + 1];
        
        return helper(dp, 1, n, n);
        
    }
    
    public int helper(int[][] dp, int sta, int end, int n) {
        if (sta >= end) return 0;
        
        if (dp[sta][end] != 0) return dp[sta][end];
        
        int min = Integer.MAX_VALUE;
        for (int val = sta; val <= end; val++) {
            int cost = val + Math.max(helper(dp, sta, val - 1, n), helper(dp, val + 1, end, n));
            if (cost < min) min = cost;
        }
        
        dp[sta][end] = min;
        return min;
    }

}
