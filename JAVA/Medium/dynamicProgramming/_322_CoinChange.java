package dynamicProgramming;

/**
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * @author xiaoyue
 *
 */

public class _322_CoinChange {
    
    
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        for (int idx = 1; idx <= amount; idx++) dp[idx] = Integer.MAX_VALUE;

        for (int coin: coins) {
            
            for (int val = coin; val <= amount; val++) {
                if (dp[val - coin] == Integer.MAX_VALUE) continue;
                dp[val] = Math.min(dp[val], dp[val - coin] + 1);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    
    public int coinChange2(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        for (int idx = 1; idx <= amount; idx++) dp[idx] = -1;

        for (int val = 1; val <= amount; val++) {
            
            int min = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (val < coin) continue;
                if (dp[val - coin] == -1) continue;
                int num = dp[val - coin] + 1;
                if (num < min) min = num;
            }
            if (min == Integer.MAX_VALUE) dp[val] = -1;
            else dp[val] = min;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _322_CoinChange test = new _322_CoinChange();
        int[] coins = new int[]{1,2,5,6};
        test.coinChange(coins, 11);
    }

}
