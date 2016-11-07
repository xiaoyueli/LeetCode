package hashtable;

import java.util.HashMap;

/**
 * Given a pattern and a string str, 
 * find if str follows the same pattern.
 * Here follow means a full match, 
 * such that there is a bijection between a letter in pattern and a non-empty word in str.
 * 
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, 
 * and str contains lowercase letters separated by a single space.
 *
 */

public class _290_WordPattern {
    
    
    // way1
    public boolean wordPattern(String pattern, String str) {
        
        char[] cseq = pattern.toCharArray();
        String[] sseq = str.split(" ");
        
        int len = cseq.length;
        if (len != sseq.length) return false;
        
        int[] locp = new int[26];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int idx = 0; idx < len; idx++) {
            char c = cseq[idx];
            String s = sseq[idx];
            if (locp[c - 'a'] == 0 && !map.containsKey(s)) {
                locp[c - 'a'] = idx + 1;
                map.put(s, idx + 1);
            }
            else if (locp[c - 'a'] == 0) return false;
            else if (!map.containsKey(s)) return false;
            else if (locp[c - 'a'] != map.get(s)) return false;
        }
        
        return true;
        
    }
    
    
    // way2
    public boolean wordPattern2(String pattern, String str) {
        
        String[] arr = str.split(" ");
        char[] pat = pattern.toCharArray();
        String[] map = new String[26];
        if (arr.length != pat.length) return false;
        if (arr.length == pat.length && arr.length == 0) return true;
        HashMap<String, Integer> strMap = new HashMap<String, Integer>();
        
        for (int idx = 0; idx < pat.length; idx++) {
            int c = pat[idx] - 'a';
            String s = arr[idx];
            if (map[c] == null) {
                map[c] = s;
                if (strMap.containsKey(s)) return false;
                strMap.put(s, c);
            }
            else if (!s.equals(map[c])) return false;
            
        }
        
        return true;       
    }
}
