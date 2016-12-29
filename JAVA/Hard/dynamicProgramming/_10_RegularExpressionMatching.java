package dynamicProgramming;

/**
 * 
 * @author xiaoyue
 * Implement regular expression matching with support for '.' and '*'.

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.
    
    The matching should cover the entire input string (not partial).
    
    The function prototype should be:
    bool isMatch(const char *s, const char *p)
    
    Some examples:
    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "a*") → true
    isMatch("aa", ".*") → true
    isMatch("ab", ".*") → true
    isMatch("aab", "c*a*b") → true
 * 
 * solution:
 * 1.递归
 * 
 * 2.dp
 */

public class _10_RegularExpressionMatching {
    
    // dp
    public boolean isMatch(String s, String p) {
        
        int ls = s.length();
        int lp = p.length();
        boolean[][] dp = new boolean[ls + 1][lp + 1];
        
        dp[0][0] = true;
        for (int ip = 2; ip <= lp; ip++) dp[0][ip] = (p.charAt(ip - 1) == '*' && dp[0][ip - 2]); // 初始化，设置 带*的每一段pattern匹配0字符时的状态，
                                                                                                //即如果之前的状态为true，那么此段带*为空时也为true
        
        for (int is = 1; is <= ls; is++) {
            for (int ip = 1; ip <= lp; ip++) {
                char cs = s.charAt(is - 1);
                char cp = p.charAt(ip - 1);
                if (cs == cp || cp == '.') dp[is][ip] = dp[is - 1][ip - 1];
                if (cp == '*' && ip - 2 >= 0) {
                    dp[is][ip] = (dp[is][ip - 2] || ( (cs == p.charAt(ip - 2) || p.charAt(ip - 2) == '.') && dp[is - 1][ip]));
                }
            }
        }
        
        return dp[ls][lp];
        
    }
    
    
    // dfs
    public boolean isMatch2(String s, String p) {
        
        if (s == null || p == null) return false;
        if (p.length() == 0) return s.length() == 0;
        if (p.length() == 1 && s.length() == 1) return checkChar(s, p);
        if (p.length() == 1) return false;
        
        if (p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || checkChar(s, p) && isMatch(s.substring(1), p); // p.substring(2) 表示该星号匹配了0个字符
        }
        
        return checkChar(s, p) && isMatch(s.substring(1), p.substring(1));
        
    }
    
    private boolean checkChar(String s, String p) {
        if (s.length() == 0 || p.length() == 0) return false;
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }

}
