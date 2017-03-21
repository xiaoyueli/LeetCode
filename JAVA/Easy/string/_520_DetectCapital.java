package string;

/**
 * 
 * @author xiaoyue
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

    We define the usage of capitals in a word to be right when one of the following cases holds:
    
    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital if it has more than one letter, like "Google".
    Otherwise, we define that this word doesn't use capitals in a right way.
    Example 1:
    Input: "USA"
    Output: True
    Example 2:
    Input: "FlaG"
    Output: False
    Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters
 *
 */

public class _520_DetectCapital {
    
    public boolean detectCapitalUse(String word) {
        
        char[] seq = word.toCharArray();
        int cnt = 0;
        
        for (char c : seq) if (isCapital(c)) cnt++;
        
        if (cnt == seq.length) return true;
        else if (cnt == 1 && isCapital(seq[0])) return true;
        else if (cnt == 0) return true;
        else return false;
        
    }
    
    private boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }

}
