package dynamicProgramming;

/**
 * Given a 2D matrix matrix, 
 * find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * 
 * Example:
 * Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
    ]
    
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 推导公式：dp[i][j] 为 0，0点到该格子的所有元素的和
 * 然后求面积和差
 *
 */

public class _304_RangeSumQuery2DImmutable {
    
    public class NumMatrix {
        
        int[][] area;
        public NumMatrix(int[][] matrix) {
            
            int height = matrix.length;
            if (height == 0)  return;
            int width = matrix[0].length;
            area = new int[height][width];
            
            area[0][0] = matrix[0][0];
            for (int col = 1; col < width; col++) area[0][col] = area[0][col - 1] + matrix[0][col];
            for (int row = 1; row < height; row++) area[row][0] = area[row - 1][0] + matrix[row][0];
            
            for (int row = 1; row < height; row++) {
                for (int col = 1; col < width; col++) {
                    area[row][col] = area[row][col - 1] + area[row - 1][col] - area[row - 1][col - 1] + matrix[row][col];
                }
            }          
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            if (row1 == 0 && col1 == 0) return area[row2][col2];
            if (row1 == 0) return area[row2][col2] - area[row2][col1 - 1];
            if (col1 == 0) return area[row2][col2] -area[row1 - 1][col2];
            return area[row2][col2] - area[row2][col1 - 1] - area[row1 - 1][col2] + area[row1 - 1][col1 -1];
        }
    }


    // Your NumMatrix object will be instantiated and called as such:
    // NumMatrix numMatrix = new NumMatrix(matrix);
    // numMatrix.sumRegion(0, 1, 2, 3);
    // numMatrix.sumRegion(1, 2, 3, 4);

}
