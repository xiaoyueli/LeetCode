package twoPointers;

/**
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? 
 * This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 */

public class _125_ValidPalindrome {
    
    public boolean isPalindrome(String s) {
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !isValid(s.charAt(left))) left++;
            while (left < right && !isValid(s.charAt(right))) right--;
            
            if (!isEqual(s.charAt(left++), s.charAt(right--))) return false;
        }
        
        return true;
    }
    
    private boolean isValid(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
    
    private boolean isEqual(char c1, char c2) {
        if (c1 == c2) return true;
        if (c1 >= '0' && c1 <= '9' || c2 >= '0' && c2 <= '9') return false;
        if (c1 - 'a' == c2 - 'A') return true;
        if (c1 - 'A' == c2 - 'a') return true;
        return false;
    }
}
