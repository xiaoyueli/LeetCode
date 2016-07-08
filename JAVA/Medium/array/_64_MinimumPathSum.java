package array;

/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * 因为只能向左和向下移动
 * 因此每一个格子的最优解来自其上和其右的格子
 */

public class _64_MinimumPathSum {
    
    public int minPathSum(int[][] grid) {
        
        for (int row = 1; row < grid.length; row++) {
            grid[row][0] += grid[row - 1][0];  
        }
        
        for (int col = 1; col < grid[0].length; col++) {
            grid[0][col] += grid[0][col - 1]; 
        }
        
        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++) {
                grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
