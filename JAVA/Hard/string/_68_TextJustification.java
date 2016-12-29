package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
    Pad extra spaces ' ' when necessary so that each line has exactly L characters.
    
    Extra spaces between words should be distributed as evenly as possible. 
    If the number of spaces on a line do not divide evenly between words, 
    the empty slots on the left will be assigned more spaces than the slots on the right.
    
    For the last line of text, it should be left justified and no extra space is inserted between words.
    
    For example,
    words: ["This", "is", "an", "example", "of", "text", "justification."]
    L: 16.
    
    Return the formatted lines as:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
    Note: Each word is guaranteed not to exceed L in length.
 */

public class _68_TextJustification {
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new ArrayList<String>();
        
        int sta = -1;
        int len = 0;
        for (int i = 0; i < words.length; i++) {

            if (sta == -1) sta = i;
            len += words[i].length();
            if (len == maxWidth) {
                res.add(getString(words, sta, i, 0, false));
                sta = -1;
                len = 0;
            }
            else if (len > maxWidth) {
                len -= words[i].length() + 1;
                res.add(getString(words, sta, i - 1, maxWidth - len, false));
                sta = i;
                len = words[i].length() + 1;
            }
            else len++;
            
        }
        
        if (sta != -1) res.add(getString(words, sta, words.length - 1, maxWidth - len + 1, true));
        
        return res;
    }
    
    private String getString(String[] words, int sta, int end, int gap, boolean lastLine) {
        
        if (sta == end) return words[sta] + space(gap);
        
        StringBuilder sb = new StringBuilder();

        String spaceStr = space(gap / (end - sta));
        int leftSpece = gap % (end - sta);
        if (lastLine) {
            spaceStr = "";
            leftSpece = 0;
        }
        for (int i = sta; i < end; i++) {
            sb.append(words[i] + " " + spaceStr);
            if (leftSpece > 0) {
                sb.append(" ");
                leftSpece--;
            }
        }
        sb.append(words[end]);
        if (lastLine) sb.append(space(gap));

        return sb.toString();
        
    }
    
    private String space(int len) {
        if (len == 0) return "";
        StringBuilder sb = new StringBuilder();
        while (len-- > 0) sb.append(" ");
        return sb.toString();
    }

}
