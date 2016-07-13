package twoPointers;

import java.util.Stack;

/**
 * Write a function that takes a string as input 
 * and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 *  stack代码简洁，效率低很多
 *
 */

public class _345_ReverseVowelsofaString {
    
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] seq = s.toCharArray();
        
        while (left <= right) {
            boolean lisVowel = isVowel(seq[left]);
            boolean risVowel = isVowel(seq[right]);
            
            if (lisVowel && risVowel) {
                char temp = seq[left];
                seq[left] = seq[right];
                seq[right] = temp;
                left++;
                right--;
            }
            else if (!lisVowel && !risVowel) {
                left++;
                right--;
            }
            else if (!lisVowel) left++;
            else right--;
        }
        
        s = new String(seq);
        return s;
        
    }
    
    public String reverseVowels2(String s) {

        char[] seq = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        
        for (char c: seq) {
            if (isVowel(c)) stack.push(c);
        }
        
        for (int idx = 0; idx < seq.length; idx++) {
            if (isVowel(seq[idx])) seq[idx] = stack.pop();
        }
        
        s = new String(seq);
        return s;
        
    }
    
    public boolean isVowel(char c) {
        switch (c) {
            case 'a': return true;
            case 'e': return true;
            case 'i': return true;
            case 'o': return true;
            case 'u': return true;
            case 'A': return true;
            case 'E': return true;
            case 'I': return true;
            case 'O': return true;
            case 'U': return true;
            default: return false;
        }
    }
}
