package array;

public class _122_BestTimetoBuyandSellStock2 {
    public int maxProfit(int[] prices) {

        int profit = 0;
        for (int idx = 0; idx < prices.length - 1; idx++) {
            if (prices[idx] < prices[idx + 1]) {
                profit += prices[idx + 1] - prices[idx];
            }
        }
        
        return profit;
    }
}
