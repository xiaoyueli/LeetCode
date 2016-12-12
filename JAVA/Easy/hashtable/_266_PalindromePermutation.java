package hashtable;

import java.util.HashMap;

/**
 * 
 * @author xiaoyue
 * 
 * Given a string, determine if a permutation of the string could form a palindrome.

    For example,
    "code" -> False, "aab" -> True, "carerac" -> True.
 * 
 */

public class _266_PalindromePermutation {
    
    public boolean canPermutePalindrome(String s) {
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] seq = s.toCharArray();
        
        for (char c: seq) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        
        int odd = 0;
        for (char c: map.keySet()) {
            if ((map.get(c) & 1) == 1) odd++;
            if (odd > 1) return false;
        }
        
        return true;
    }

}
