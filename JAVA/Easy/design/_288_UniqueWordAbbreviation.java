package design;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 *        1
 *   b) d|o|g                   --> d1g
 *   
 *                 1    1  1
 *        1---5----0----5--8
 *   c) i|nternationalizatio|n  --> i18n
 *                1
 *       1---5----0
 *  d) l|ocalizatio|n          --> l10n
 *  
 *  Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
 *  A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 *  
 *  
 *  Example: 
 *  Given dictionary = [ "deer", "door", "cake", "card" ]
 *  
 *  isUnique("dear") -> false
 *  isUnique("cart") -> true
 *  isUnique("cane") -> false
 *  isUnique("make") -> true
 *  
 *  题意：
 *  isUnique为真的条件：
 *  1. dic里字符的缩写需要唯一
 *  2. 如果在dic里缩写唯一，则被判断的单词与dic的单词一样则为真，否则为假
 *  3. dic为空，和2个字符及以下的单词，不在dic的单词为真
 */

import java.util.HashMap;

public class _288_UniqueWordAbbreviation {

    HashMap<String, String> map;
    public _288_UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<String, String>();
        
        for (String word: dictionary) {
            if (word.length() > 2) {
                String abbr = getAbbreviation(word);
                if (map.containsKey(abbr)) map.put(abbr, "0");
                else map.put(abbr, word);
            }
        }
    }

    public boolean isUnique(String word) {
        
        if (word.length() <= 2) return true;
        
        String abbr = getAbbreviation(word);
        if (!map.containsKey(abbr)) return true;
        
        String sign = map.get(abbr);
        if (sign.equals("0")) return false;
        return sign.equals(word);
    }
    
    private String getAbbreviation(String word) {
        
        int len = word.length();
        if (len <= 2) return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(len - 2);
        sb.append(word.charAt(len - 1));
        
        return  sb.toString();
    }
    
    public static void main(String[] args) {
        _288_UniqueWordAbbreviation test = new _288_UniqueWordAbbreviation(new String[]{"dig","dug","dag","dog","doge"});
//        System.out.println(test.getAbbreviation("dog"));
        System.out.println(test.isUnique("dog"));
        
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
