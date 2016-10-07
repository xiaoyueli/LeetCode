package dynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * 
 * 思路：
 * 分别记录当前日期做一次交易，和做两次交易能获得的最大利润
 */

public class _123_BestTimetoBuyandSellStock3 {
    
    public int maxProfit(int[] prices) {
              
        int len = prices.length;
        if (len < 2) return 0;
        
        int buyOne = 0, buyTwo = 0;
        int maxBuyOne = 0, maxBuyTwo = 0;
        
        for (int idx = 1; idx < len; idx++) {
            int diff = prices[idx] - prices[idx - 1];
            
            // 在前一天卖出能获得的利润 + 差值  VS 差值==前一天买入今天卖出
            buyOne = Math.max(buyOne + diff, diff); 
            // 在前一天卖出能获得的利润 + 差值  VS 截止前一天交易一次的最大利润+ 新的一次交易的利润
            buyTwo = Math.max(buyTwo + diff, maxBuyOne + diff);
            
            maxBuyOne = Math.max(maxBuyOne, buyOne);
            maxBuyTwo = Math.max(maxBuyTwo, buyTwo);
            
        }
        
        return maxBuyTwo;
    }
    
//    从前从后分别找出当前日期进行一次交易可以获得的最大值
//    public int maxProfit(int[] prices) {
//        
//        int buy = Integer.MAX_VALUE;
//        int maxPro = 0;
//        int len = prices.length;
//        
//        int[] oneTraPro = new int[len];
//        int[] oneTraProRev = new int[len];
//        
//        for (int day = 0; day < len; day++) {
//            int price = prices[day];
//            
//            if (buy > price) buy = price;
//            else if (maxPro < price - buy) {
//                maxPro = price - buy;
//            }
//            oneTraPro[day] = maxPro;
//            // System.out.print(maxPro + " ");
//        }
//        // System.out.println();
//        int sell = Integer.MIN_VALUE;
//        maxPro = 0;
//        for (int day = len - 1; day >= 0; day--) {
//            int price = prices[day];
//            
//            if (price > sell) sell = price;
//            else if (sell - price > maxPro) {
//                maxPro = sell - price;
//            }
//            oneTraProRev[day] = maxPro;
//            // System.out.print(maxPro + " ");
//        }
//        
//        maxPro = 0;
//        for (int day = 0; day < len; day++) {
//            if (maxPro < oneTraPro[day] + oneTraProRev[day]) {
//                maxPro = oneTraPro[day] + oneTraProRev[day];
//            }
//        }
//        
//        return maxPro;
//        
//    }

}
