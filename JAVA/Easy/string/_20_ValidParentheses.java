package string;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * # 
 */

public class _20_ValidParentheses {
    
    public boolean isValid(String s) {
        
        char[] seq = s.toCharArray();
        
        Stack<Character> stack = new Stack<Character>();
        
        for (char c: seq) {
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (!isPair(left, c)) return false;
            }
            else stack.push(c);
        }
        
        return stack.isEmpty();
    }
    
    private boolean isPair(char l, char r) {
        if (l == '(') return r == ')';
        if (l == '{') return r == '}';
        if (l == '[') return r == ']';
        return false;
    }
    
    public static void main(String[] args) {
        _20_ValidParentheses test = new _20_ValidParentheses();
        test.isValid("()");
    }

}
