package dynamicProgramming;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * 思路：动态规划
 * 用一维数组记录当前下标是否有substring可以到达（可能是一个也可能是多个）
 * dp[n] 即为所求
 * 
 * 1,外层循环表示满足条件的下标重新作为起点寻找之后的substring
 * 
 */

public class _139_WordBreak {
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        
        char[] arr = s.toCharArray();
        int len = arr.length;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        
        for (int idx = 0; idx < len + 1; idx++) {
            
            if (dp[idx]) {
                // idx 作为起点，遍历以idx为起点的所以长度的字符串是否存在
                // 若存在则表示，只需确认之后的字符串是否存在匹配单词
                for (int sublen = 1; sublen < len - idx + 1; sublen++) {
                    if (wordDict.contains(s.substring(idx, idx + sublen))) {
                        dp[idx + sublen] = true;
                    }
                }
            }
            
            if (dp[len]) return true;
        }
        
        return dp[len];
        
        
    }

}
