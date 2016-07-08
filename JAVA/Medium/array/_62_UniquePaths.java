package array;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * 到达每一个格子的方法，等于到达其左边格子和上边格子方法的和；
 */

public class _62_UniquePaths {
    
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        
        path[0][0] = 1;
        for (int row = 1; row < m; row++) {
            path[row][0] += path[row - 1][0]; 
        }
        for (int col = 1; col < n; col++) {
            path[0][col] += path[0][col - 1];
        }
        
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                path[row][col] = path[row][col - 1] + path[row - 1][col];
            }
        }
        
        return path[m - 1][n - 1];
    }
}
