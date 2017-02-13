package dynamicProgramming;

/**
 * 
 * @author xiaoyue
 * 
 * There are a row of n houses, each house can be painted with one of the k colors. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.

    The cost of painting each house with a certain color is represented by a n x k cost matrix. 
    For example, costs[0][0] is the cost of painting house 0 with color 0; 
    costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
    
    Note:
    All costs are positive integers.
    
    Follow up:
    Could you solve it in O(nk) runtime?
 * 思路：
 * 更新使用当前颜色的房子的成本时，加上上一个房子成本最低的颜色的成本
 * 如果当前颜色和上一个房子的最低成本颜色相等，就加上第二低颜色的成本。
 * 
 * 也就是，每次只需记得最低成本的颜色和第二低成本的颜色
 * 更新成本时，最低成本颜色的房子 加上次低颜色的成本。其他颜色的房子都加上最低成本颜色的成本
 */

public class _265_PaintHouse2 {
    
    public int minCostII(int[][] costs) {
        
        int len = costs.length;
        
        int firMin = 0;
        int secMin = 0;
        
        for (int i = 0; i < len; i++) {
            int fMin = Integer.MAX_VALUE;
            int sMin = Integer.MAX_VALUE;
            for (int j = 0; j < costs[0].length; j++) {
                if (i != 0 && costs[i - 1][j] != firMin) costs[i][j] += firMin;
                else if (i != 0) costs[i][j] += secMin;
                
                if (costs[i][j] < fMin) {
                    sMin = fMin;
                    fMin = costs[i][j];
                }
                else if (costs[i][j] < sMin) sMin = costs[i][j];
            }
            firMin = fMin;
            secMin = sMin;
        }        
        return firMin;   
    }

}
