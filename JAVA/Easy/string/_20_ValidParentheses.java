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
        
        Stack<Character> stack = new Stack<Character>();
        char[] seq = s.toCharArray();
        int len = seq.length;
        
        for (int idx = 0; idx < len; idx++) {
            char c = seq[idx];
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else if (stack.isEmpty()) return false;
            else {
                char other = stack.pop();
                if (other == '(') {
                    if (c != ')') return false;
                }
                else if (other == '[') {
                    if (c != ']') return false;
                }
                else if (c != '}') return false;
            }
        }
        
        if (stack.isEmpty()) return true;
        return false;
    }
    
    public static void main(String[] args) {
        _20_ValidParentheses test = new _20_ValidParentheses();
        test.isValid("()");
    }

}
