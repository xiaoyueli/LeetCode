package array;

/**
 * Given an integer n, 
 * generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 */

public class _59_SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        
        int layer = (n + 1) / 2;
        int num = 1;
        for (int i = 0; i < layer; i++) {
            
            for (int col = i; col < n - i; col++) {
                ans[i][col] = num++;
            }
            
            for (int row = i + 1; row < n - i; row++) {
                ans[row][n - 1 - i] = num++;
            }
            
            if (n - 1 - i > i) {
                for (int col = n - 1 - i - 1; col >= i; col--) {
                    ans[n - 1 - i][col] = num++;
                }
            }
            
            if (i < n - 1 - i) {
                for (int row = n - 1 - i - 1; row > i; row--) {
                    ans[row][i] = num++;
                }
            }
        }       
        return ans;
    }
}