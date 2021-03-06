package hashtable;

/**
 * Given two strings s and t which consist of only lowercase letters.
 * 
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * Find the letter that was added in t.
 * 
 * Example:
 * 
 * Input:
 * s = "abcd"
 * t = "abcde"
 * 
 * Output:
 * e
 * 
 * Explanation:
 * 'e' is the letter that was added.
 *
 */

public class _389_FindtheDifference {

    public char findTheDifference(String s, String t) {
        
        int[] counts = new int[26];
        int[] countt = new int[26];
        
        char[] str = s.toCharArray();
        int slen = str.length;
        char[] text = t.toCharArray();
        int tlen = text.length;
        
        for (int idx = 0; idx < slen; idx++) {
            char c = str[idx];
            counts[c - 'a']++;
        }
        
        for (int idx = 0; idx < tlen; idx++) {
            char c = text[idx];
            countt[c - 'a']++;
        }
        
        int idx = 0;
        for (; idx < 26; idx++) {
            if (counts[idx] != countt[idx]) {
                break;
            }
        }
        
        return (char)('a' + idx);
    }

}
