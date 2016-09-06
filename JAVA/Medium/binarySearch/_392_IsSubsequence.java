package binarySearch;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. 
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string 
 * by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * 
 * Return true.
 * 
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * 
 * Return false.
 * 
 * 顺序遍历即可
 *
 */

public class _392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        
        char[] str = s.toCharArray();
        char[] text = t.toCharArray();
        int tlen = text.length;
        int slen = str.length;
        if (slen == 0) return true;
        int match = 0;
        char schar = str[match];
        for (int idx = 0; idx < tlen; idx++) {
            
            char tchar = text[idx];
            if (tchar == schar) {
                match++;
                if (match == slen) return true;
                schar = str[match];
                
            }
        }
        
        return false;
    }

}
