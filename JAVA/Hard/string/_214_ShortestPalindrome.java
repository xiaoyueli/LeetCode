package string;

/**
 * 
 * @author xiaoyue
 * 
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.

    For example:
    
    Given "aacecaaa", return "aaacecaaa".
    
    Given "abcd", return "dcbabcd".
 * 
 * 思路：
 * brute force: 从后到前check最长palindrome. reverse不是palindrome的部分加到最前面即可
 * 
 */

public class _214_ShortestPalindrome {
    
    public String shortestPalindrome(String s) {
        
        char[] seq = s.toCharArray();
        int len = seq.length;
        int i = len - 1;
        for (; i >= 0; i--) {
            
            int left = 0;
            int right = i;
            while (left < right && seq[left] == seq[right]) {
                left++; 
                right--;
            }
            
            if (left >= right) break;
        }
        
        String sub = reverse(s.substring(i + 1, len));
        
        return sub + s;
    }
    
    private String reverse(String s) {
        char[] seq = s.toCharArray();
        int lo = 0, hi = seq.length - 1;
        while (lo < hi) {
            char temp = seq[lo];
            seq[lo] = seq[hi];
            seq[hi] = temp;
            lo++; hi--;
        }
        
        return new String(seq);
    }

}
