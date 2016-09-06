package dynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * 
 * You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * 
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 * 
 * 思路，每一天的进行的操作分四总情况：
 * 持有1股票什么都不做 （前一天买入一股票或持有1股票什么都不做的最优解）
 * 没有股票什么都不做 （前一天卖出股票或没有股票什么都不做的最优解）
 * 没有股票购入1股票（前一天没有股票什么都不做的最优解 - 当天的股价）
 * 持有1股票并卖出 （前一天持有1股票的最优解 + 当天的股价）
 * 
 * PS 买入相当于支付，卖出相当于获得
 * 
 * 
 *
 */

public class _309_BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        
        if (len < 2) return 0;
        
        int has1_doNothing = -prices[0];
        int has1_sell1 = 0;
        int has0_doNothing = 0;
        int has0_buy1 = -prices[0];
        
        for (int day = 1; day < len; day++) {
            int price = prices[day];
            
            has1_doNothing = Math.max(has0_buy1, has1_doNothing);  // the optimal choice of day - 1 has a stock    
            
            has0_buy1 = has0_doNothing - price; // before buy there should be cooldown or has0_doNothing
            
            has0_doNothing = Math.max(has0_doNothing, has1_sell1); // day - 1 : has0_doNothing or has1_sell1

            has1_sell1 = has1_doNothing + price;  // already update has1_doNothing of day -1, so plus price directly
            
            
        }

        return Math.max(has1_sell1, has0_doNothing);
    }

}
