package dynamicProgramming;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Return 4.
 * 
 * @author xiaoyue
 * 
 * 思路： dp
 * 每次加入一个1格子，以当前格子为右下角往左上看，能形成多大的方块
 * 取决于当前格子上面，左边，左上的格子，分别能形成多大的方块。
 * 新形成的格子大小等于上面三个位子的最小值+1.
 * 
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * 
 * 
 *
 */

public class _221_MaximalSquare {
    
    public int maximalSquare(char[][] matrix) {
        
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows + 1][cols + 1];
        int max = 0;
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    if (max < dp[i][j]) max = dp[i][j];
                }
            }
        }
        
        return max * max;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       

    }

}
