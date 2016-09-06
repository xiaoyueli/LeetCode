package dynamicProgramming;

public class _123_BestTimetoBuyandSellStock3 {
    
    public int maxProfit(int[] prices) {
        
        int buy = Integer.MAX_VALUE;
        int maxPro = 0;
        int len = prices.length;
        
        int[] oneTraPro = new int[len];
        int[] oneTraProRev = new int[len];
        
        for (int day = 0; day < len; day++) {
            int price = prices[day];
            
            if (buy > price) buy = price;
            else if (maxPro < price - buy) {
                maxPro = price - buy;
            }
            oneTraPro[day] = maxPro;
            // System.out.print(maxPro + " ");
        }
        // System.out.println();
        int sell = Integer.MIN_VALUE;
        maxPro = 0;
        for (int day = len - 1; day >= 0; day--) {
            int price = prices[day];
            
            if (price > sell) sell = price;
            else if (sell - price > maxPro) {
                maxPro = sell - price;
            }
            oneTraProRev[day] = maxPro;
            // System.out.print(maxPro + " ");
        }
        
        maxPro = 0;
        for (int day = 0; day < len; day++) {
            if (maxPro < oneTraPro[day] + oneTraProRev[day]) {
                maxPro = oneTraPro[day] + oneTraProRev[day];
            }
        }
        
        return maxPro;
        
    }

}
