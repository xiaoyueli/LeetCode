package array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * For example,
 * Consider the following matrix:
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 *
 */

public class _74_Searcha2DMatrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        
        int left = 0;
        int right = rows * cols - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int row = mid / cols;
            int col = mid % cols;
            int val = matrix[row][col];
            if (val == target) return true;
            if (val < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return false;
    }
}
