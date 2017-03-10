package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * 
 * Given a List of words, 
 * return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * 
 * Example 1:
    Input: ["Hello", "Alaska", "Dad", "Peace"]
    Output: ["Alaska", "Dad"]
    Note:
    You may use one character in the keyboard more than once.
    You may assume the input string will only contain letters of alphabet.
 *
 */

public class _500_Keyboard_Row {
    
    public String[] findWords(String[] words) {
        char[][] chars = new char[][]{{'Q','W','E','R','T','Y','U','I','O','P'},
            {'A','S','D','F','G','H','J','K','L'},
            {'Z','X','C','V','B','N','M'}};
            
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < chars.length; i++) {
            for (char c: chars[i]) map.put(c, i);
        }
        
        List<String> ls = new ArrayList<String>();
        for (String word: words) {
            if (isInSameRow(word, map)) ls.add(word);
        }
        
        
        return ls.toArray(new String[0]);
        
    }
    
    public boolean isInSameRow(String word, HashMap<Character, Integer> map) {
        
        char[] seq = word.toUpperCase().toCharArray();
        int index = map.get(seq[0]);
        for (int i = 1; i < seq.length; i++) {
            if (index != map.get(seq[i])) return false;
        }
        
        return true;
    }

}
