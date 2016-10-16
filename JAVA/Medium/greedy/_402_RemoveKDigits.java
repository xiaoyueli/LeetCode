package greedy;

import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, 
 * remove k digits from the number so that the new number is the smallest possible.
 * 
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * 
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 从左往右遍历字符串，存入栈里。大致保证栈为最小可能的增序列，最后取栈里前len - k 个字符。
 * 入栈规则：
 * 遇到0时，栈为空则跳过，不能有leading 0;
 * 若此时待删除的元素 >= 栈内的元素数量，则将栈内元素全部出栈，这样剩余数字可以减小一个量级
 * 若遇到数字大于栈顶元素则入栈
 * 否则在待删除元素数量大于零时，弹出栈顶元素，直到当前元素<=栈顶元素
 * 
 * notice:
 * 随时check栈是否为空
 * 栈为空时，0字符不能入栈
 *
 */

public class _402_RemoveKDigits {
    
    public String removeKdigits(String num, int k) {
        
        char[] seq = num.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int len = seq.length;
        
        int left = k;

        for (char c: seq) {
            int val = c - '0';
            
            if (val == 0) {
                if (stack.isEmpty()) continue;
                while (!stack.isEmpty() && left >= stack.size()) {
                    stack.pop();
                    left--;
                }
                if (stack.isEmpty()) continue;
            }
            
            while (!stack.isEmpty() && val < stack.peek() && left > 0) {
                stack.pop();
                left--;
            }
            if (val == 0 && stack.isEmpty()) continue;
            stack.push(val);
        }
        
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i: stack) {
            if (cnt == len - k) break;
            sb.append(i);
            cnt++;
            
        }
        
        if (sb.length() == 0) return "0";
        return sb.toString();
        
    }

}
