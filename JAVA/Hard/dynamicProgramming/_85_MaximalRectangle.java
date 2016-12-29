package dynamicProgramming;

/**
 * 
 * @author xiaoyue
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

    For example, given the following matrix:
    
    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0
    Return 6.
 *
 */

public class _85_MaximalRectangle {
    
    public int maximalRectangle(char[][] matrix) {
        
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows + 1][cols + 1];
        int max = 0;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    dp[row + 1][col + 1] = dp[row + 1][col] + 1;
                    int area = calculate(dp, row + 1, col + 1);
                    if (area > max) max = area;
                }
            }
        }
        
        return max;
    }
    
    private int calculate(int[][] dp, int row, int col) {
        int height = 1;
        int width = dp[row][col];
        int max = dp[row][col];
        
        while (row >= 0 && dp[row][col] > 0) {
            if (dp[row][col] < width) width = dp[row][col];
            if (width * height > max) max = width * height;
            height++;
            row--;
        }
        
        return max;
    }

}
