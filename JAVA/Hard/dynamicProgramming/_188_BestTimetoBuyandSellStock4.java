package dynamicProgramming;

/**
 * 
 * @author xiaoyue
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 *
 */

public class _188_BestTimetoBuyandSellStock4 {
    
    public int maxProfit(int k, int[] prices) {
        
        int len = prices.length;
        if (len <= 1 || k == 0) return 0;
        
        // 当k大于天数时，相当于求不限次数交易的最大利润
        if (k >= len) {         
            int buy = prices[0];
            int profit = 0;
            for (int idx = 1; idx < len; idx++) {
                if (prices[idx] > prices[idx - 1]) continue;
                else {
                    profit += prices[idx - 1] - buy;
                    buy = prices[idx];
                }
            }
            return profit;
        }
        
        
        // 递推公司同问题3， 当天第k次交易自身+当天利润差，和上一次交易的最大利润+当天利润差，的较大值再与全局最大利润取较大值，则为当天k次交易的最大利润
        int[][] dp = new int[k + 1][len];
        
        for (int i = 1; i <= k; i++) {
            int max = 0;
            int buyI = 0;
            for (int p = 1; p < len; p++) {
                int profit = prices[p] - prices[p - 1];
                buyI = Math.max(buyI + profit, dp[i - 1][p - 1] + profit);
                max = Math.max(max, buyI);
                dp[i][p] = max;
            }
        }
        
        return dp[k][len - 1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
