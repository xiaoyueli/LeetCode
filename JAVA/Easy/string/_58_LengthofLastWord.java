package string;

/**
 * Given a string s consists of upper/lower-case alphabets and 
 * empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 *
 */

public class _58_LengthofLastWord {
    
    public int lengthOfLastWord(String s) {
        
        char[] seq = s.toCharArray();
        int len = seq.length;
        int res = 0;

        for (int idx = len - 1; idx >= 0; idx--) {
            char c = seq[idx];
            if (c == ' ' && res == 0) continue;
            else if (c == ' ') return res;
            else res++;
        }

        return res;
        
    }
}
