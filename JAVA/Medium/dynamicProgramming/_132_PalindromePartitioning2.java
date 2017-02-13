package dynamicProgramming;

/**
 * 
 * @author xiaoyue
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.

    Return the minimum cuts needed for a palindrome partitioning of s.
    
    For example, given s = "aab",
    Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * 思路：
 * 以每一个点为中心点，向左向右寻找最长的palindrome, 更新从这个点能形成的最远palindrome需要cuts的数量
 * 分奇数和偶数palindrome 检查
 */

public class _132_PalindromePartitioning2 {
    
    public int minCut(String s) {
        
        char[] seq = s.toCharArray();
        int[] cuts = new int[seq.length + 1];
        for (int i = 0; i <= seq.length; i++) cuts[i] = i - 1; // 初始化到每一个element至少需要cuts多少次能保证是palindrome, 3个数cuts两次
        
        for (int i = 0; i < seq.length; i++) {
            
            for (int len = 0; i - len >= 0 && i + len < seq.length; len++) {  // odd palindrome
                if (seq[i - len] == seq[i + len]) {
                    cuts[i + len + 1] = Math.min(cuts[i + len + 1], cuts[i - len] + 1);
                }else break;
            }
            
            for (int len = 1; i - (len - 1) >= 0 && i + len < seq.length; len++ ) { // even palindrome
                if (seq[i - len + 1] == seq[i + len]) {
                    cuts[i + len + 1] = Math.min(cuts[i + len + 1], cuts[i - len + 1] + 1);
                }else break;
            }
        }
        
        return cuts[seq.length];
        
    }

}
