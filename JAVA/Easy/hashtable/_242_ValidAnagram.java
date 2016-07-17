package hashtable;

/**
 * Given two strings s and t, 
 * write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? 
 * How would you adapt your solution to such case?
 *
 */

public class _242_ValidAnagram {
    
    public boolean isAnagram(String s, String t) {
        
        if (s.length() == 0 && t.length() == 0) return true;
        else if (s.length() != t.length()) return false;
        
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int[] map = new int[26];
    
        for (int idx = 0; idx < arrS.length; idx++) {
            map[arrS[idx] - 'a']++;
            map[arrT[idx] - 'a']--;
        }
        
        for (int idx = 0; idx < map.length; idx++) {
            if (map[idx] != 0) return false;
        }
        
        return true;
        
        
    }
}
