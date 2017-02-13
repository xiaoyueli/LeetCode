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
    
    // On Space(n)
    public int hIndex(int[] citations) {
        
        int length = citations.length;
        int[] count = new int[length + 1];
        
        for (int num: citations) {
            if (num > length) count[length]++;
            else count[num]++;
        }
        
        for (int i = length; i > 0; i--) {
            if (count[i] >= i) return i;
            else count[i - 1] += count[i];
        }
        
        return 0;
    }
    
    
    // nlogn
    public int hIndex2(int[] citations) {
        
        Arrays.sort(citations);
        int length = citations.length;
        
        int hidx = 0;

        for (int i = 0; i < length; i++) {
            if (length - i <= citations[i]) return length - i;
        }
        
        return 0;
    }
}