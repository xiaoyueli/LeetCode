package dynamicProgramming;

/**
 * 
 * @author xiaoyue
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * 思路：
 * 动态规划，
 * 1.如果当前字符相等，则steps与上一组字符相等
 * 否者三种情况取最小值
 * replace: dp[i - 1][j - 1] + 1;
 * 字符串1.insert/delete: dp[i - 1][j] + 1;
 * 字符串2.insert/delete: dp[i][j - 1] + 1;
 *
 */

public class _72_EditDistance {
    
    public int minDistance(String word1, String word2) {
        
        char[] seq1 = word1.toCharArray();
        char[] seq2 = word2.toCharArray();
        
        int len1 = seq1.length;
        int len2 = seq2.length;
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (seq1[i - 1] == seq2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else {
                    int min = dp[i - 1][j - 1] + 1;
                    if (min > dp[i - 1][j] + 1) min = dp[i - 1][j] + 1;
                    if (min > dp[i][j - 1] + 1) min = dp[i][j - 1] + 1;
                    dp[i][j] = min;
                }
            }
        }
        
        return dp[len1][len2];
        
    }

}
