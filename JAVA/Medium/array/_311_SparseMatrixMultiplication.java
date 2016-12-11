package array;

/**
 * 
 * @author xiaoyue
 * 
 * Given two sparse matrices A and B, return the result of AB.

    You may assume that A's column number is equal to B's row number.
    
    Example:
    
    A = [
      [ 1, 0, 0],
      [-1, 0, 3]
    ]
    
    B = [
      [ 7, 0, 0 ],
      [ 0, 0, 0 ],
      [ 0, 0, 1 ]
    ]   
    
         |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
    AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                      | 0 0 1 |
 * 
 * 思路，loop 遍历A数组的每一个元素， 若不为0，在res数组上相应的位置+= 该元素与B数组对应元素的乘积
 * 
 */

public class _311_SparseMatrixMultiplication {
    
    public int[][] multiply(int[][] A, int[][] B) {
        
        int rowA = A.length;
        int colA = A[0].length;
        int[][] res = new int[rowA][B[0].length];
        
        for (int row = 0; row < rowA; row++) {
            for (int col = 0; col < colA; col++) {
                
                if(A[row][col] == 0) continue;
                
                for (int idx = 0; idx < B[0].length; idx++) {
                    res[row][idx] += A[row][col] * B[col][idx];
                }
                  
            }
        }
        
        return res;
    }

}
