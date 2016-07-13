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
        int len = s.length();
        
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            boolean lvalid = isValidChar(s.charAt(left));
            boolean rvalid = isValidChar(s.charAt(right));
            if (lvalid && rvalid) {
                if (isSame(s.charAt(left), s.charAt(right))) {
                    left++;
                    right--;
                }
                else return false;
            }
            else if (!lvalid) left++;
            else right--;
        }
        return true;
    }
    
    public boolean isValidChar(char c) {
        if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') return true;
        return false;
    }
    
    public boolean isSame(char a, char b) {
        
        if (a == b) return true;
        if (a > '9' && b > '9') {
            if ('a' + a - 'A' == b) return true;
            if ('A' + a - 'a' == b) return true;
        }

        return false;
    }
}
