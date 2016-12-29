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
        String[][] map = new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"},
        {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        
        
        if (digits.length() == 0) return res;
        
        helper(res, map, digits, "", 0, digits.length());
        
        return res;
        
    }
    
    private void helper(List<String> res, String[][] map, String digits, String path, int pos, int len) {
        if (pos == len) {
            res.add(path);
            return;
        }
        
        String[] strs = map[digits.charAt(pos) - '0'];
        for (int i = 0; i < strs.length; i++) {
            helper(res, map, digits, path + strs[i], pos + 1, len);
        }
    }

}
