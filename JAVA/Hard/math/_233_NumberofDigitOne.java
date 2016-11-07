package math;

/**
 * 
 * @author xiaoyue
 * 
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * 
 * 思路：
 * 先计算数字为几位数时能保证一共有几个1：
 * 0- 9： 1
 * 10 - 99： pow(10, 1) + 9 * (0 - 9的1)
 * 100- 999： pow(10, 2) + 9 * (10 - 99的 1)  分别表示，百位为1的数 + 9倍两位数含有的1
 * 
 * 然后用DP数组累计到目前位数的和
 * 
 * 然后将数字从最高位分段，递归
 *  
 *
 */

public class _233_NumberofDigitOne {
       
    public int countDigitOne(int n) {
        
        if (n < 1) return 0;
        if (n < 10) return 1;
        
        int len = (n +"").toCharArray().length;     // 计算是几位数
        
        int[] dp = new int[len];
        
        // idx 表示当前位数至少有多少1， 例如idx = 3, 表示小于100的数的1的数量
        dp[1] = 1;
        for (int idx = 2; idx < len; idx++) {
            dp[idx] = dp[idx - 1] * 9 + (int)Math.pow(10, idx - 1) + dp[idx - 1];
        }
        
        int sum = helper(dp, n);
        
        return sum;
        
    }
    
    private int helper(int[] dp, int num) {
        
        if (num < 1) return 0;
        if (num < 10) return 1;

        int len = (num +"").toCharArray().length;
        
        int scale = (int)Math.pow(10, len - 1);
       
        int digit = num / scale;
        
        // 把原来的数字从最高位分开，例如 526 分成 500 和 26 
        // 小于500的1有 5倍 0- 99 的和
        // 0- 99, 100- 199, 200- 299, 300- 399, 400- 499 ,其中100 - 199 还需加上 100这个数量级
        int sum = 0;
        if (digit >= 2) sum = digit * dp[len - 1] + helper(dp, num % scale) + scale;
        else sum = dp[len - 1] + helper(dp, num % scale) + num % scale + 1;

        return sum;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _233_NumberofDigitOne test = new _233_NumberofDigitOne();
        test.countDigitOne(100);

    }

}
