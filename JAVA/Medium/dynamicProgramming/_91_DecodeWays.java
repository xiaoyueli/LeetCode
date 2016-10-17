package dynamicProgramming;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 题目的意思，0不属于可以解码的范围，只能与其他数字组合解码，如果出现无效组合则无解，例如0， 00， 30等
 * 动态规划：
 * 根据当前字符和前一个字符的状态求解
 * 一共有三种情况
 * 1，当前字符自身可以decode。则至少保证前一个字符的解得数量，因为当前字符自身decode加上它之后不影响总的解得数量
 * 2，当前字符可以与前一个字符结合在一起。则产生的变化是，前一个字符自身decode + 当前字符自身decode 是一种情况， 另外，它们组合在一个又是一组解，
 * 这时可以看作在加上前一个字符时，多了一组解得情况，因此需加上前一个字符之前的解的数量
 * 3，当前字符+前一个字符无解。00的情况
 *
 */

public class _91_DecodeWays {
    
    public int numDecodings(String s) {
        
        char[] seq = s.toCharArray();
        int len = seq.length;
        int[] dp = new int[len + 1];
        
        if (len == 0) return 0;
        
        if (seq[0] == '0') return 0;
        else dp[1] = 1;
        
        if (len == 1) return dp[1];
        
        dp[0] = 1; // 处理第一和第二个字符可以组合的初始化。

        
        for (int idx = 2; idx <= len; idx++) {
            int cur = seq[idx - 1] - '0';
            int pre = seq[idx - 2] - '0';
            
            // 无解的情况
            if (cur == 0 && pre == 0) return 0;
            
            // 当前字符可以自身decode的话，至少保证有和前一个字符被decode同样的解的数量
            if (cur != 0) dp[idx] = dp[idx - 1]; 
            
            // 当前字符可以与前一个字符组合的情况下，则除前一个字符自身decode的数量， 还要加上与当前字符组合在一起的解得数量
            // 即在前一个字符之前的解的基础上有两种情况，因为需加上前一个字符之前累计的解得数量 
            if (pre == 1 || pre == 2 && cur >= 0 && cur <= 6) dp[idx] += dp[idx - 2];   
                                    

        }
        return dp[len];
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        _91_DecodeWays test = new _91_DecodeWays();
        test.numDecodings("101");

    }

}
