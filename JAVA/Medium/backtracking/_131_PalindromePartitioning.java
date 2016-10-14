package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * 
 * [
      ["aa","b"],
      ["a","a","b"]
 * ]
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 递增切出subStirng, 如果切出来的subString 是回文的，加入list递归后面的subString
 * 否则就跳过；
 *
 */

public class _131_PalindromePartitioning {
    
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) return res;
        
        List<String> list = new ArrayList<String>();
        
        helper(res, list, s);
        
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> list, String str) {
        int len = str.length();
        if (len == 0) {
            List<String> copy = new ArrayList<String>(list);
            res.add(copy);
            return;
        }
        
        for (int idx = 1; idx <= len; idx++) {
            String sub = str.substring(0, idx);
            if (isPalindrome(sub)) {
                list.add(sub);
                helper(res, list, str.substring(idx, len));
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        char[] seq = str.toCharArray();
        int len = seq.length;
        if (len == 1) return true;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (seq[left] == seq[right]) {
                left++;
                right--;
            }
            else return false;
        }
        
        return true;
    }

}
