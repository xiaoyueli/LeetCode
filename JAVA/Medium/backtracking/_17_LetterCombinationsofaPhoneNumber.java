package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * 
 * @author xiaoyue
 *
 */

public class _17_LetterCombinationsofaPhoneNumber {
    
    public List<String> letterCombinations(String digits) {     
        
        List<String> res = new ArrayList<String>();
        char[][] seq = new char[][]{{}, 
                                    {},
                                    {'a','b','c'},
                                    {'d','e','f'},
                                    {'g','h','i'},
                                    {'j','k','l'},
                                    {'m','n','o'},
                                    {'p','q','r','s'},
                                    {'t','u','v'},
                                    {'w','x','y','z'}};
                                        
        char[] digs = digits.toCharArray();
        int[] nums = new int[digs.length];
        int len = nums.length;
        if (len == 0) return res;
        
        for (int idx = 0; idx < len; idx++) nums[idx] = digs[idx] - '0';
        char[] coms = new char[len];
        
        helper(res, nums, seq, coms, 0);
        
        return res;      
    }
    
    public void helper(List<String> res, int[] nums, char[][] seq, char[] coms, int pos) {
        int len = nums.length;
        if (pos == len) {
            res.add(new String(coms));
            return;
        }
        
        int seqlen = seq[nums[pos]].length;
        
        for (int idx = 0; idx < seqlen; idx++) {
            coms[pos] = seq[nums[pos]][idx];
            helper(res, nums, seq, coms, pos + 1);
        }
   
    }

}
