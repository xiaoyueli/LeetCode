package twoPointers;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, 
 * "pwke" is a subsequence and not a substring.
 * 
 * 用一个数组记录字符上一次出现的位子，
 * 动态修改开始位子，和累计长度
 * 
 */

public class _3_LongestSubstringWithoutRepeatingCharacters {
    
    public int lengthOfLongestSubstring(String s) {
        
        int[] map = new int[128];
        for (int idx = 0; idx < map.length; idx++) map[idx] = -1;
        int sta = 0;
        int len = 0;
        int maxlen = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            if (map[c] < sta) {
                len++;
                map[c] = idx;
            }
            else {
                if (len > maxlen) maxlen = len;
                sta = map[c] + 1;
                len = idx - map[c];
                map[c] = idx;
            }
        }
        
        if (len > maxlen) return len;

        return maxlen;
    }
}
