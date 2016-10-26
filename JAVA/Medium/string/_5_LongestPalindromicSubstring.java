package string;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 方法1：动态规划
 * 2d数组。行表示substring 的长度
 *        列表示起始坐标
 * d[i][j] 表示起点为j 长度为i的字符串是否是回文
 * 递推公式 d[i][j] = 比较在j位置的字符与substring最后一个字符是否匹配，不匹配则为false 否则 = d[i - 2][j + 1]的状态，即去掉两头后中间的字符是否是回文
 *  
 * 方法二：Manacher’s Algorithm 
 * http://blog.csdn.net/hopeztm/article/details/7932245
 * 创建新字符串在原始字符的每个字符前后插入一个标记符'#'， 插入'#'用于可以判断每一个字符前后是否对称
 * 创建于新字符串等长的数组用于记录以每一个字符为中心的回文字符串长度
 * 用一个变量center存当前覆盖最远的回文字符串的中心，right存覆盖范围的右边界
 * 原理，就是
 * 当遍历一个新的字符i，如果该字符在覆盖范围内，则说明与center对称的另一边，即center的左边 有它的镜像i' ，
 * 因为对称原理可确定i to center 与center to i'是对称的， 且i'的回文长度已经算过，则可以根据i'的值求i得值
 * 由于多插入'#'符号，可知i为中心的记录的回文长度与i的左右两侧覆盖的回文范围等长，加入'#'相当于扩大两倍
 * 因为如果right - i 的数量 > dp[i'] 则说明i的回文覆盖范围在center之内，更新dp[i] = de[i']
 * 否则，只能说i与i'的对称性到right结束，超过right后i任然可能构成新的回文段，这时就需要扩展这个对称范文
 * 
 * 当dp[i] + i > right 后，就要更新新的覆盖最远的center为i， 和right值
 * 
 * 
 */

public class _5_LongestPalindromicSubstring {
    
    public String longestPalindrome(String s) {
               
        int len = s.length();
        char[] seq = new char[2 * len + 1];
        seq[0] = '#';
        for (int idx = 1; idx < 2 * len; idx += 2) {
            seq[idx] = s.charAt(idx / 2);
            seq[idx + 1] = '#';
        }
        
        len = len * 2;
        int center = 0, right = 0;
        int[] dp = new int[len + 1];
        
        int maxlen = 0;
        int staCen = 0;
        
        for (int idx = 1; idx < len; idx++) {
            int cur_mirror = center * 2 - right;
            
            dp[idx] = idx < right ? Math.min(dp[cur_mirror], right - idx) : 0;
            
            while (idx + 1 + dp[idx] < len + 1 &&
                    idx - 1 - dp[idx] >= 0 && seq[idx + 1 + dp[idx]] == seq[idx - 1 - dp[idx]]) {
                dp[idx]++;
            }
            
            if (dp[idx] + idx > right) {
                center = idx;
                right = dp[idx] + idx;
            }
            
            if (dp[idx] > maxlen) {
                maxlen = dp[idx];
                staCen = idx;
            }
            
        }
        
        int sta = (staCen - maxlen) / 2;
        
        return s.substring(sta, sta + maxlen);   
    
    }
    
    public String longestPalindrome1(String s) {
        
        
        char[] seq = s.toCharArray();
        int length = seq.length;
        boolean[][] dp = new boolean[length + 1][length];
        
        int maxlen = 1;
        int begin = 0;
        
        
        for (int len = 1; len <= length; len++) {
            
            for (int start = 0; start < length; start++) {
                int sta = start;
                int end = start + len - 1;
                if (end >= length) continue;
                
                if (seq[sta] == seq[end] && (sta + 1 >= end || dp[len - 2][start + 1])) {   // sta + 1 >= end 用于判断substring长度为1和2的情况，即没有中间的字符串
                    dp[len][start] = true; 
                    if (len > maxlen) {
                        maxlen = len;
                        begin = start;
                    }
                }
                else dp[len][start] = false;
       
            }
        }
        

        return s.substring(begin, begin + maxlen);
    
    }
    
    public static void main(String[] args) {
        _5_LongestPalindromicSubstring test = new _5_LongestPalindromicSubstring();
//        test.longestPalindrome("abb");
        System.out.println(15 >> 1);
    }

}
