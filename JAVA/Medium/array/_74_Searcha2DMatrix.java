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
        
        int row = matrix.length;
        for (int idx = 0; idx < matrix.length; idx++) {
            if (target < matrix[idx][0]) {
                row = idx - 1;
                break;
            }
        }
        if (row < 0) return false;
        else if (row == matrix.length) {
            if (target > matrix[row - 1][matrix[row - 1].length - 1]) return false;
            row--;
        }
        
        return bs(matrix[row], target);
        
    }
    
    public boolean bs(int[] nums, int tar) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == tar) return true;
            if (nums[mid] < tar) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
