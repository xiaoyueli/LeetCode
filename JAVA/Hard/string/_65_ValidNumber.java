package string;

/**
 * 
 * @author xiaoyue
 * 
 * Validate if a given string is numeric.

    Some examples:
    "0" => true
    " 0.1 " => true
    "abc" => false
    "1 a" => false
    "2e10" => true
    Note: It is intended for the problem statement to be ambiguous. 
    You should gather all requirements up front before implementing one.
 *
 */

public class _65_ValidNumber {
    
    public boolean isNumber(String s) {
        
        boolean seeE = false;
        boolean seeP = false;
        boolean seeNum = false;
        boolean numAfterE = true;
        
        s = s.trim();
        char[] seq = s.toCharArray();
        
        for (int i = 0; i < seq.length; i++) {
            char cur = seq[i];
            if (isNum(cur)) {
                seeNum = true;
                numAfterE = true;
            }
            else if (cur == '.') {
                if (seeP || seeE) return false;
                seeP = true;
            }
            else if (cur == 'e') {
                if (seeE || !seeNum) return false;
                seeE = true;
                numAfterE = false;
            }
            else if (cur == '+' || cur == '-') {
                if (i != 0 && seq[i - 1] != 'e') return false;
            }
            else return false;
        }
        
        return seeNum && numAfterE;
        
    }
    
    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

}
