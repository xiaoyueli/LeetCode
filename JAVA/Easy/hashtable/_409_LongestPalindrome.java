package hashtable;

/**
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * @author xiaoyue
 *
 */

public class _409_LongestPalindrome {
	
    public int longestPalindrome(String s) {
        
        char[] seq = s.toCharArray();
        int[] lower = new int[26];
        int[] upper = new int[26];
        
        int len = seq.length;
        for (int idx = 0; idx < len; idx++) {
            char cur = seq[idx];
            int val = cur - 'a';
            if (val >= 0 && val < 26) lower[val]++;
            else upper[cur - 'A']++;
        }
        
        int sum = 0;
        boolean odd = false;
        for (int idx = 0; idx < 26; idx++) {
            int val = lower[idx];
            
            if (val != 0) {
                sum += val / 2 * 2;
                if (val % 2 == 1) odd = true;
            }
            
            val = upper[idx];
            if (val != 0) {
                sum += val / 2 * 2;
                if (val % 2 == 1) odd = true;
            }
        }
        
        if (odd) sum += 1;
        
        return sum;
        
    }

}
