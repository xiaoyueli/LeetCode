package hashMap;

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
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
   
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int length = word.length();
            
            for (int j = 0; j <= length; j ++) {
                String front = word.substring(0, j);
                String back = word.substring(j, length);
                if (isPalindrome(front) && map.containsKey(back) && i != map.get(back)) 
                    addPair(res, map.get(back), i);
                if (isPalindrome(back) && map.containsKey(front) && i != map.get(front) && !front.equals(word)) 
                    addPair(res, i, map.get(front));
            }
        }
        
        return res;
    }
    
    private void addPair(List<List<Integer>> res, int i, int j) {

        List<Integer> pair = new ArrayList<Integer>();
        pair.add(i);
        pair.add(j);
        res.add(pair);
    }
    
    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) return false;
        }
        return true;
    }

}
