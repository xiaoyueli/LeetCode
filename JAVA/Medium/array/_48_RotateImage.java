package array;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 * 
 * 顺时针90度：先左上到右下对角线交换，再左右互换
 * 逆时针90度：先右上到左下对角线交换，在左右互换
 *
 */

public class _48_RotateImage {
    public void rotate(int[][] matrix) {
        
        int len = matrix.length;

        for (int row = 0 ; row < len; row++) {
            for (int col = row; col < len; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        
        for (int row  = 0; row < len; row++) {
            for (int col = 0; col < len / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][len - 1 - col];
                matrix[row][len - 1 - col] = temp;
            }
        }

    }
}
