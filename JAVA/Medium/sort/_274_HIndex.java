package sort;

import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, 
 * write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: 
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 * 
 * For example, given citations = [3, 0, 6, 1, 5], 
 * which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. 
 * Since the researcher has 3 papers with at least 3 citations each and 
 * the remaining two with no more than 3 citations each, his h-index is 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * H_idx 是 所有大于此idx的著作数量大于等于此idx
 *
 */

public class _274_HIndex {
    
    public int hIndex(int[] citations) {
        
        int len = citations.length;
        int[] caculate = new int[len + 1];
        
        
        for (int idx = 0; idx < len; idx++) {
            // idx 表示著作数量
            if (citations[idx] >= len) caculate[len]++; //计算引文值  大于等于最大著作数的数量
            else caculate[citations[idx]]++;    // 计算 引文值等于著作数的数量
        }
        
        int sum = 0;
        for (int idx = len; idx >= 0; idx--) {
            if (caculate[idx] + sum >= idx) return idx;
            sum += caculate[idx];
        }
        
        return 0;
    }
    
    public int hIndex2(int[] citations) {
        
        Arrays.sort(citations);
        
        int len = citations.length;
        int maxH = 0;
        
        for (int idx = 0; idx < len; idx++) {
            if (citations[idx] >= len - idx) {
                int hidx = len - idx;
                if (hidx > maxH) maxH = hidx;
            }
        }
        
        return maxH;
    }
}