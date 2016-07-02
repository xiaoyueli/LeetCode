package array;

public class _121_BestTimetoBuyandSellStock {
    
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for (int idx = 0; idx < prices.length; idx++) {
            if (prices[idx] < min) min = prices[idx];
            else if (prices[idx] - min > profit) profit = prices[idx] - min;
        }
        return profit;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
