package dynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * 
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 
 * (not 7-1 = 6, as selling price needs to be larger than buying price)
 * 
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 */

public class _121_BestTimetoBuyandSellStock {
    
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE;
        int profit = 0;
        int days = prices.length;
        for (int day = 0; day < days; day++) {
            int price = prices[day];
            if (price < min) min = price;
            if (price - min > profit) profit = price - min; 
        }
        return profit;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	_121_BestTimetoBuyandSellStock test = new _121_BestTimetoBuyandSellStock();
    	test.maxProfit(new int[]{1,2});
    }

}
