package binarySearch;

/**
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * For example,
 * Consider the following matrix:
 * 
 * [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
    ]
    
   Given target = 5, return true.
   Given target = 20, return false.
 */

public class _240_Searcha2DMatrix2 {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int width = matrix[0].length;
        int height = matrix.length;
        int col = width - 1;
        
        for (int row = 0; row < height && col >= 0; row++) {
            int first = matrix[row][0];
            int last = matrix[row][col];
            if (last == target || first == target) return true;
            if (last < target) continue;
            if (first > target) break;
            int left = 1;
            int right = col - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int val = matrix[row][mid];
                if (val == target) return true;
                if (val < target) left = mid + 1;
                else right = mid - 1;
            }
            col = right;
            
        }
        
        return false;
        
    }

}
