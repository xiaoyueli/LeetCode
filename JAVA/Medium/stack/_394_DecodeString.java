package stack;

/**
 * Given an encoded string, return it's decoded string.
 * 
 * The encoding rule is: k[encoded_string], 
 * where the encoded_string inside the square brackets is being repeated exactly k times. 
 * Note that k is guaranteed to be a positive integer.
 * 
 * You may assume that the input string is always valid; 
 * No extra white spaces, square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
 * For example, there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 思路：
 * 遇到‘[’ 就把之前的substr进栈 跟新start位置
 * 遇到']'就出栈， 如果栈顶不含数字，就将这些substr连起来，直到遇到数字，再repeat之前连接起来的substr
 * 
 * 连接栈内元素，返回
 */

import java.util.Stack;

public class _394_DecodeString {
    
    public String decodeString(String s) {

        //"2[abc]3[cd]ef"
        
        // abcabc cdcdcd

        
        Stack<String> stack = new Stack<String>();
        
        int sta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(s.substring(sta, i));
                sta = i + 1;
            }
            else if (s.charAt(i) == ']') {
                if (sta != i) stack.push(s.substring(sta, i));
                sta = i + 1;
                StringBuilder sb = new StringBuilder();
                while (!isNum(stack.peek().charAt(stack.peek().length() - 1))) {
                    sb.insert(0, stack.pop());
                }
                
                String sub = stack.pop();
                int j = 0;
                for (; j < sub.length(); j++) {
                    if (isNum(sub.charAt(j))) break;
                }
                
                int num = Integer.parseInt(sub.substring(j));
                
                String str = getRepeat(sb.toString(), num);
                if (j > 0) {
                    str = sub.substring(0, j) + str;
                }
                stack.push(str);
            }
        }
        
        stack.push(s.substring(sta, s.length()));
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        
        return sb.toString();

    }
    
    private String getRepeat(String str, int num) {
        StringBuilder sb = new StringBuilder();
        while (num-- > 0) sb.append(str);
        return sb.toString();
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String args[]) {
        // TODO Auto-generated method stub
        _394_DecodeString test = new _394_DecodeString();
        test.decodeString("3[a2[c]]");

    }

}
