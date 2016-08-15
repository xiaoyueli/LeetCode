/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 *
 *  不会动态规划的方法
 *
 *  方法一，two pointer:
 *  思路：如果字符匹配或者遇到'?'，两个指针同时增加，
 *  如果遇到'*', 则记录回溯位置:p为当前位置+1， s为当前位置
 *  如果两个字符不匹配，P回到回溯位置，S回到回溯位子下一位
 */

public class Q_44_WildcardMatching {
    
    public boolean isMatch(String s, String p) {
        
        char[] seq = s.toCharArray();
        char[] pat = p.toCharArray();
        
        int idxs = 0;
        int idxp = 0;
        int lens = seq.length;
        int lenp = pat.length;
        int cacheS = -1;
        int cacheP = -1;

        while (idxs < lens) {

            if (idxp < lenp && (seq[idxs] == pat[idxp] || pat[idxp] == '?')) {
                idxs++;
                idxp++;
                continue;
            }

            if (idxp < lenp && pat[idxp] == '*') {
                idxp++;
                cacheP = idxp;
                cacheS = idxs;
                continue;
            }
            
            if (cacheS != -1) {
                idxs = ++cacheS;
                idxp = cacheP;
                continue;
            }

            return false;
            
        }

        while (idxp < lenp && pat[idxp] == '*') idxp++;
        return idxp == lenp;

    }

}
