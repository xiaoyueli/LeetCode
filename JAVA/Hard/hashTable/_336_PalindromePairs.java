package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, 
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

    Example 1:
    Given words = ["bat", "tab", "cat"]
    Return [[0, 1], [1, 0]]
    The palindromes are ["battab", "tabbat"]
    Example 2:
    Given words = ["abcd", "dcba", "lls", "s", "sssll"]
    Return [[0, 1], [1, 0], [3, 2], [2, 4]]
    The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 *
 * 思路：
 * 将所有word的reverse 存入hashmap
 * 单独检查，是否存在"" 若存在需加入若有自身是回文的单词的两组坐标
 * 单独检查完整word。
 * 然后loop所有词，将单词分成前后两半 check前半是回文的情况，后半是否在map内。同样情况check后半。
 * 
 * 
 * On * 每个word的长度
 */

public class _336_PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < words.length; i++) {
            map.put(reverse(words[i]), i);
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int length = word.length();
            
            if (map.containsKey("") && isPalindrome(word) && !word.equals("")) {
                res.add(getList(map.get(""), i));
                res.add(getList(i, map.get("")));
            }
            
            if (map.containsKey(word) && i > map.get(word)) {
                res.add(getList(map.get(word), i));
                res.add(getList(i, map.get(word)));
            }
            
            for (int len = 1; len < length; len++) {
                String front = word.substring(0, len);
                String back = word.substring(len, length);
                if (isPalindrome(front) && map.containsKey(back)) res.add(getList(map.get(back), i));
                if (isPalindrome(back) && map.containsKey(front)) res.add(getList(i, map.get(front)));
            }
        }
        
        return res;
    }
    
    private List<Integer> getList(int i, int j) {
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(i);
        ls.add(j);
        return ls;
    }
    
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        char[] seq = s.toCharArray();
        for (char c: seq) sb.insert(0, c);
        return sb.toString();
    }
    
    private boolean isPalindrome(String s) {
        
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        
        return true;
    }

}
