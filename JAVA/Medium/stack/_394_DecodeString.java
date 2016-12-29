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
 * 遇到数字时，判断前面有没有遇到字母串，如有则进栈字母串。并记录数字
 * 遇到字母，判断字母的开头标记是不是为-1， 如是则记录字母开始的位置，否则什么也不做
 * 遇到"[" 则将累计的数字进栈，将数字累计符归0
 * 遇到"]"则判断栈顶是不是数字，如是。则pop出数字重复当前字母串，在push回去
 * 否则Pop栈顶元素知道栈顶是数字，并将pop出的字母串连接起来重新Push进栈
 * 注意最后以字母串结束时需单独处理
 * 
 * 连接栈内元素，返回
 */

import java.util.Stack;

public class _394_DecodeString {
    
    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        int staNum = -1;
        int staChar = -1;
        
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (isNum(cur) && staNum == -1) {
                staNum = i;
                if (staChar != -1) {
                    stack.push(s.substring(staChar, i));
                    staChar = -1;
                }
            }
            else if (cur == '[') {
                stack.push(s.substring(staNum, i));
                staNum = -1;
            }
            else if (cur == ']') {
                
                if (staChar != -1) {
                    stack.push(s.substring(staChar, i));
                    staChar = -1;
                }
                concatenateString(stack);
            }
            else if (!isNum(cur) && staChar == -1) staChar = i;
        }
        
        if (staChar != -1) {
            stack.push(s.substring(staChar, s.length()));
            concatenateString(stack);
        }
        
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        
        return sb.toString();
    }
    
    private void concatenateString(Stack<String> stack) {

        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty() && !isNum(stack.peek().charAt(0))) {
            sb.insert(0, stack.pop());
        }
        
        if (!stack.isEmpty()) {
            String baseStr = sb.toString();
            sb = new StringBuilder();
            int loop = Integer.parseInt(stack.pop());
            for (int i = 0; i < loop; i++) sb.append(baseStr);
        }
   
        stack.push(sb.toString());
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
