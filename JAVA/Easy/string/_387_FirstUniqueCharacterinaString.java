package string;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * Examples:
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * @author xiaoyue
 *
 */

public class _387_FirstUniqueCharacterinaString {
	
    public int firstUniqChar(String s) {
        
        char[] seq = s.toCharArray();
        int len = seq.length;
        if (s == null || len == 0) return -1;
        
        int[] count = new int[26];
        
        for (int idx = 0; idx < len; idx++) {
            count[seq[idx] - 'a']++;
        }
        
        for (int idx = 0; idx < len; idx++) {
            if (count[seq[idx] - 'a'] == 1) return idx;
        }
        
        return -1;
    }

}
