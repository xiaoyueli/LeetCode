package dynamicProgramming;

import java.util.Stack;

/**
 * 
 * @author xiaoyue 
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.

    For "(()", the longest valid parentheses substring is "()", which has length = 2.
    
    Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * 思路：dp， element是当前字符最长有效长度
 * 如果当前是'('什么都不做
 * 如果当前是')'
 * 1，检查前一个字符是否是'('，如果是，就在前一个字符的前一个字符的最长有效长度基础上+2；
 * 2，如果前一个字符时')'，获得前一个字符的最长有效长度，减去这个长度后，检查再前一个字符是否是'('，如果是，就加上这三段的有效长度，
 * 即，前一个字符减去有效长度后再前字符的有效长度，+前一个字符的有效长度，+新增加的2.
 */

public class _32_LongestValidParentheses {
    
    public int longestValidParentheses(String s) {
        
        char[] seq = s.toCharArray();
        int[] dp = new int[seq.length + 1];
        int max = 0;
        
        for (int i = 1; i < seq.length; i++) {
            
            if (seq[i] == '(') continue;
            if (seq[i - 1] == '(') dp[i + 1] = dp[i - 1] + 2;
            else if (i - dp[i] - 1 >=0 && seq[i - dp[i] - 1] == '(') dp[i + 1] = dp[i] + 2 + dp[i - dp[i] - 1];
            if (max < dp[i + 1]) max = dp[i + 1];
        }
        return max;
        
    }
    
    
    // 用stack来存右括号的坐标，遇到左括号时，如果为空，就更新当前有效的最左的坐标。
    // 否则pop出最近的右括号坐标。之后，当前坐标到stack.peek的坐标差值，就是当前有效的括号长度。依此更新最大值
    public int longestValidParentheses1(String s) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int left = -1;
        int max = 0;
        char[] seq = s.toCharArray();
        for (int i = 0; i < seq.length; i++) {
            char cur = seq[i];
            if (cur == '(') stack.push(i);
            else if (stack.isEmpty()) left = i;
            else {
                stack.pop();
                if (stack.isEmpty()) max = Math.max(max, i - left);
                else max = Math.max(max, i - stack.peek());
            }
        }
        
        return max;
        
    }

}
