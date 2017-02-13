package array;

/**
 * Given a m x n matrix, if an element is 0, 
 * set its entire row and column to 0. Do it in place.
 * 
 * 用第0行和第0列来标记相应的行列是否需要置0，
 */

public class _73_SetMatrixZeroes {
    
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean fr = false;
        boolean fc = false;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0) fr = true;
                    if (col == 0) fc = true;
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) matrix[row][col] = 0;
            }
            if (fc) matrix[row][0] = 0;
        }
        
        if (fr) {
            for (int col = 0; col < cols; col++) matrix[0][col] = 0;
        }

        
    }
}


