package array;

import java.util.List;

/**
 * 建一维数组求和
 *  从下往上保存对应路径可能的最小和
 *  O(n) + extra space
 */

public class _120_Triangle {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int size = triangle.size();
        List<Integer> ls = triangle.get(size - 1);
        int[] sums = new int[size];
        for (int i = 0; i < size; i++) {
            sums[i] = ls.get(i);
        }
        
        for (int row = size - 2; row >= 0; row--) {
            ls = triangle.get(row);
            for (int idx = 0; idx < ls.size(); idx++) {
                sums[idx] = ls.get(idx) + Math.min(sums[idx], sums[idx + 1]);
            }
            
        }
        
        return sums[0];
        
    }
    
}
