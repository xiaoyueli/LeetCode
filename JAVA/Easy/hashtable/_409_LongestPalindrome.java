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
        
        int[] mark = new int[128];
        
        for (char c: seq) mark[c]++;
        
        int sum = 0;
        boolean isOdd = false;
        for (int i: mark) {
            if (i % 2 == 0) sum +=i;
            else {
                sum += i - 1;
                isOdd = true;
            }
        }
        
        if (isOdd) return sum + 1;
        return sum;
        
    }

}
