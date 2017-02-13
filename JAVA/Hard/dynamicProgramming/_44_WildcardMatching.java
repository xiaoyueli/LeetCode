package dynamicProgramming;
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
 *  如果遇到'*', 则记录回溯位置:p为当前位置， s为当前位置 + 1
 *  如果两个字符不匹配，P回到回溯位置，S回到回溯位子
 */

public class _44_WildcardMatching {
    
    public boolean isMatch(String s, String p) {
        
        char[] str = s.toCharArray();
        char[] pat = p.toCharArray();
        
        int backs = -1;
        int backp = -1;
        int ip = 0;
        int is = 0;
        while (is < str.length) {        

            if (ip < pat.length && (str[is] == pat[ip] || pat[ip] == '?')) {
                ip++;
                is++;
            }
            else if (ip < pat.length && pat[ip] == '*') {
                backs = is + 1;
                backp = ip;
                ip++;
            }
            
            else if (backp != -1) {  // 如果两个字符不同，或者P已经走完，但是S还没有走完，则回到回溯位子，如果没有回溯位，则返回falseß
                is = backs;
                ip = backp;
            }
            else return false;

        }
        
        while (ip < pat.length && pat[ip] == '*') ip++;

        
        return ip == pat.length;
    }
    
    // dp
    public boolean isMatch1(String s, String p) {
        
        int ls = s.length();
        int lp = p.length();
        boolean[][] dp = new boolean[ls + 1][lp + 1];
        
        dp[0][0] = true;
        // 初始化，用pattern 匹配空字符串。 
        // 如果p == '*', 则当前匹配状态 等于'*'前一个字符与空字符串匹配的结果
        for (int i = 0; i < lp; i++) if (p.charAt(i) == '*') dp[0][i + 1] = dp[0][i]; 
                                                                                               
        for (int i = 0; i < ls; i++) {
            for (int j = 0; j < lp; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*') dp[i + 1][j + 1] = (dp[i][j + 1] || dp[i + 1][j]);
                // dp[i][j + 1] 代表'*'至少匹配上一个字符，则当前字符匹配状态等于'*'匹配s前一个字符的状态
                // dp[i + 1][j] 代表'*'匹配到0个字符，则当前字符匹配状态等于'*'前一个字符与当前s字符的匹配结果
            }
        }
        return dp[ls][lp];
 
    }

}
