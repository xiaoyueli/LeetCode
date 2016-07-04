package array;

import java.util.List;

/**
 * 建二维数组求和
 *  从下往上保存对应路径可能的最小和
 *  O(n) + extra space
 */

public class _120_Triangle {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int len = triangle.size();
        int[][] sumTable = new int[len][];
        
        sumTable[len - 1] = new int[len];
        List<Integer> lastlist = triangle.get(len - 1);
        for (int idx = 0; idx < len; idx++) {
            sumTable[len - 1][idx] = lastlist.get(idx);
        }
        
        for (int row = len - 2; row >= 0; row--) {
            lastlist = triangle.get(row);
            int sublen = lastlist.size();
            sumTable[row] = new int[sublen];
            for (int idx = 0; idx < sublen; idx++) {
                sumTable[row][idx] = lastlist.get(idx) + Math.min(sumTable[row + 1][idx], sumTable[row + 1][idx + 1]);
            }
        }
        
        
        return sumTable[0][0];
    }
    
}
