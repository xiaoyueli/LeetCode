package twoPointers;

/**
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 */

public class _28_ImplementstrStr {
    
    // boyer moore
    public int strStr(String haystack, String needle) {
        
        
        char[] hay = haystack.toCharArray();
        char[] pat = needle.toCharArray();
        
        if (pat.length == 0) return 0;
        
        int[] map = new int[128];
        for (int idx = 0; idx < 128; idx++) map[idx] = -1;
        for (int idx = 0; idx < pat.length; idx++) map[pat[idx]] = idx;
        
        int skip;
        for (int idx = 0; idx <= hay.length - pat.length; idx += skip) {
            
            int rear;
            for (rear = pat.length - 1; rear >= 0; rear--) {
                if (hay[idx + rear] != pat[rear]) break;
            }
            if (rear == -1) return idx;
            skip = rear - map[hay[idx + rear]];
            if (skip < 1) skip = 1;
        }
        
        return -1;
         
    }
    
    // kmp
    public int strStr3(String haystack, String needle) {
        
        
        String h = haystack;
        String n = needle;
        
        if (n.length() == 0) return 0;
        
        int[][] kmp = buildKmp(needle);
        
        int idxn = 0;
        int idxh = 0;
        for (; idxh < h.length() && idxn < n.length(); idxh++) {
            idxn = kmp[h.charAt(idxh)][idxn];
        }
        
        if (idxn == n.length()) return idxh - idxn;
        return -1;
        
    }
    
    public int[][] buildKmp(String str) {
        int[][] kmp = new int[256][str.length()];
        
        kmp[str.charAt(0)][0] = 1;
        
        for (int back = 0, idx = 1; idx < str.length(); idx++) {
            for (int c = 0; c < 256; c++) {
                kmp[c][idx] = kmp[c][back];
            }
            kmp[str.charAt(idx)][idx] = idx + 1;
            
            back = kmp[str.charAt(idx)][back];
        }
        
        return kmp;
    }
    
    
    // 暴力求解
    public int strStr2(String haystack, String needle) {

        int length = haystack.length();
        int len = needle.length();
        
        if (len > length) return -1;
        
        for (int i = 0; i <= length - len; i++) {
            if (haystack.substring(i, i + len).equals(needle)) return i;
        }
        
        return -1;
        
    }
}