package twoPointers;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * 
 * Example:
 * Given s = "hello", return "olleh".
 *
 */

public class _344_ReverseString {
    
    public String reverseString(String s) {
        char[] res = s.toCharArray();
        int left = 0;
        int right = res.length - 1;
        
        while (left < right) {
            char temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            left++;
            right--;
        }
        
        s = new String(res);
        
        return s;
    }
}


