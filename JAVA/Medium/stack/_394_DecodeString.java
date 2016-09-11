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
    
    char[] str;
    int len;
    public String decodeString(String s) {
        
        str = s.toCharArray();
        len = str.length;
        Stack<String> stack = new Stack<String>();
        if (len == 0) return s;
        
        int sta = -1;
        int sum = 0;
        // "3[a]2[bc]"
        
        for (int idx = 0; idx < len; idx++) {
            char cur = str[idx];

            if (isNum(cur)) {
                if (sta != -1) {
                    stack.push(s.substring(sta, idx));
                    sta = -1;
                }
                sum = sum * 10 + (cur - '0');    
            }
            else if (cur == '[') {
                stack.push(sum + "");
                sum = 0;
            }
            else if (cur == ']') {
                
                String sub = "";
                if (sta != -1) {
                    sub = s.substring(sta, idx);
                    sta = -1;
                }
                
                if (!isNum(stack.peek().charAt(0))) {
                    while (!isNum(stack.peek().charAt(0))) {
                        sub = stack.pop() + sub;
                    }
                }
                
                StringBuffer sb = new StringBuffer();
                int repeat = Integer.parseInt(stack.pop());
                while (repeat != 0) {
                    sb.append(sub);
                    repeat--;
                }
                stack.push(sb.toString());
                
            }
            else if (sta == -1) sta = idx;
            
        }
        
        if (sta != -1) stack.push(s.substring(sta, len));
        
        if (stack.isEmpty()) return s;
        String res = stack.pop();
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }

        return res;
        
    }
    
    public boolean isNum(char c) {
        int value = c - '0';
        if (value >= 0 && value <= 9) return true;
        return false;
    }

    public static void main(String args[]) {
        // TODO Auto-generated method stub
        _394_DecodeString test = new _394_DecodeString();
        test.decodeString("3[a2[c]]");

    }

}
