package string;

/**
 * 
 * @author xiaoyue
 * 
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

    A string such as "word" contains only the following valid abbreviations:
    
    ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
    Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
    
    Note:
    Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
    
    Example 1:
    Given s = "internationalization", abbr = "i12iz4n":
    
    Return true.
    Example 2:
    Given s = "apple", abbr = "a2e":
    
    Return false.
 *
 */

public class _408_ValidWordAbbreviation {
    
    public boolean validWordAbbreviation(String word, String abbr) {
        
        char[] ori = word.toCharArray();
        char[] seq = abbr.toCharArray();
        
        int cnt = 0;
        int pass = 0;
        
        int idx = 0;
        for (int i = 0; i < ori.length; i++) {
            
            
            if (idx < seq.length && isNum(seq, idx)) {
                if (cnt == 0 && seq[idx] == '0') return false;
                cnt = cnt * 10 + (seq[idx] - '0');
                pass++;
                idx++;
                if (idx < seq.length && !isNum(seq, idx) || idx == seq.length) {
                    cnt -= pass;
                    pass = 0;
                }
            }
            else if (cnt < 0) return false;
            else if (cnt > 0) cnt--;
            else if (cnt == 0 && (idx == seq.length ||seq[idx] != ori[i])) return false;
            else idx++;


        }
        
        return idx == seq.length && cnt == 0;
    }
    
    private boolean isNum(char[] seq, int pos) {
        return seq[pos] >= '0' && seq[pos] <= '9';
    }

}
