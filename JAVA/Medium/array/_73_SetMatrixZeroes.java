package array;

/**
 * Given a m x n matrix, if an element is 0, 
 * set its entire row and column to 0. Do it in place.
 * 
 * 用第0行和第0列来标记相应的行列是否需要置0，
 * 单独对0行0列遍历判断是否需要置0，
 * 从第1行 和 第1列开始遍历
 */

public class _73_SetMatrixZeroes {
    
    public void setZeroes(int[][] matrix) {
        
        boolean rZero = false;
        boolean cZero = false;
        
        for (int i: matrix[0]) {
            if (i == 0) {
                rZero = true;
                break;
            }
        }
        
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                cZero = true;
                break;
            }
        }
              
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        
        // 这里需要从第一行开始，否则影响列的判断
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) mark(matrix, row, -1);
        }
        
        // 同上
        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) mark(matrix, -1, col);
        }
        
        if (rZero) mark(matrix, 0, -1);
        if (cZero) mark(matrix, -1, 0);
    }
    
    public void setZeroes2(int[][] matrix) {
        
        int height = matrix.length;
        int width = matrix[0].length;
        
        boolean[] arrRow = new boolean[height];
        boolean[] arrCol = new boolean[width];
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (matrix[row][col] == 0) {
                    arrRow[row] = true;
                    arrCol[col] = true;
                }
            }
        }
        
        for (int row = 0; row < height; row++) {
            if (arrRow[row]) mark(matrix, row, -1);
        }
        
        for (int col = 0; col < width; col++) {
            if (arrCol[col]) mark(matrix, -1, col);
        }
        
    }
    
    public void mark(int[][] nums, int r, int c) {
        if (r >= 0) {
            for (int col = 0; col < nums[r].length; col++) {
                nums[r][col] = 0;
            }
        }

        if (c >= 0) {
            for (int row = 0; row < nums.length; row++) {
                nums[row][c] = 0;
            }
        }       
    }
}


