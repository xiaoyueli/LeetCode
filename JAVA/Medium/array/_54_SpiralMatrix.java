package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix
 *[
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 */

public class _54_SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<Integer>();
        int height = matrix.length;
        
        if (height == 0) return list;
        int width = matrix[0].length;

        int layer = (Math.min(height, width) + 1) / 2;
        
        for (int idx = 0; idx < layer; idx++) {
            
            for (int col = idx; col < width - idx; col++) {
                list.add(matrix[idx][col]);
            }
            
            for (int row = idx + 1; row < height - idx; row++) {
                list.add(matrix[row][width - idx - 1]);
            }
            
            if (height - 1 - idx > idx)
                for (int col = width - 1 - idx - 1; col >= idx; col--) {
                    list.add(matrix[height - 1 - idx][col]);
                }
            
            if (idx < width - idx - 1)
                for (int row = height - 1 - idx - 1; row > idx; row--) {
                    list.add(matrix[row][idx]);
                }
            
        }        
        return list;
    }
}
