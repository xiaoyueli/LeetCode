package math;

import java.util.Stack;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * 将val循环除以10；
 * 累计每一次的余数 * 10 + 下一次的余数
 * 累计值等于VAL返回True
 */

public class _9_PalindromeNumber {
    
    public boolean isPalindrome(int x) {
        
        if (x < 0) return false;
        int sum = 0;
        int num = x;
        
        while (num != 0) {
            sum  = sum * 10 + num % 10;
            num /= 10;
        }
        
        return sum == x;
        
    }
    
    public boolean isPalindrome2(int x) {
        Stack<Integer> stack = new Stack<Integer>();
        if (x < 0) return false;
        
        int val = x;
        while (val != 0) {
            stack.push(val % 10);
            val = val / 10;
        }
        val = x;
        while (!stack.isEmpty()) {
            int digit = val % 10;
            if (digit != stack.pop()) return false;
            val /= 10;
        }
        
        return true;
        
    }
}
