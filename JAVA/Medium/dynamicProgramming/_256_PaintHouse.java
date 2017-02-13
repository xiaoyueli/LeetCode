package dynamicProgramming;

/**
 * 
 * @author xiaoyue
 * 
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.

    The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
    For example, costs[0][0] is the cost of painting house 0 with color red; 
    costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

    Note:
    All costs are positive integers.
 * 
 *
 */

public class _256_PaintHouse {
    
    public int minCost(int[][] costs) {
        
        int len = costs.length;
        if (len == 0) return 0;
        
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        
        for (int i = 1; i < len; i++) {
            
            int cr = red;
            int cb = blue;
            int cg = green;
            
            red = Math.min(cb, cg) + costs[i][0];
            blue = Math.min(cr, cg) + costs[i][1];
            green = Math.min(cr, cb) + costs[i][2];
            
        }
        
        return Math.min(red, Math.min(blue, green));
    }

}
