package facebook;

/**
 * 
 * @author xiaoyue
 * 
 * 找出两个给出两个string, leetcode, codyabc和一个数字k = 3,问两个string里面存不存在连续的common substring大于等于k.
 * 比如这个例子，两个string都有cod,所以返回true。楼主用dp建了一个m*n的table秒了，然后写test case,发现有个小corner case,改了,pass
 * Longest common substring
 *
 */

public class _LongestCommonSubstring {
    
    public boolean solve(String a, String b, int k) {
        char[] seqa = a.toCharArray();
        char[] seqb = b.toCharArray();
        int la = a.length();
        int lb = b.length();
        int[][] dp = new int[la + 1][lb + 1];
        
        for (int i = 1; i <= la; i++) {
            for (int j = 1; j <= lb; j++) {
                if (seqa[i - 1] == seqb[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                if (dp[i][j] >= k) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _LongestCommonSubstring test = new _LongestCommonSubstring();
        String a = "abc";
        String b = "abcd";
        System.out.println(test.solve(a, b, 3));
    }

}
