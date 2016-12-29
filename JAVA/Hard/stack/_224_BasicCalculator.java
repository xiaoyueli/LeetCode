package stack;

import java.util.Stack;

/**
 * 
 * @author xiaoyue
 * 
 * Implement a basic calculator to evaluate a simple expression string.

    The expression string may contain open ( and closing parentheses ), 
    the plus + or minus sign -, non-negative integers and empty spaces .
    
    You may assume that the given expression is always valid.
    
    Some examples:
    "1 + 1" = 2
    " 2-1 + 2 " = 3
    "(1+(4+5+2)-3)+(6+8)" = 23
    Note: Do not use the eval built-in library function.
 * 
 * 思路：
 * 用一个sign保存当前符号
 * 用一个栈保存进入括号时的符号，如果括号前是负号，说明里面每一个数都需要*-1. 遇到后括号时，再将当前sign逆转回来。
 * 
 * 剩余部分就是常规的加减运算
 * 
 */

public class _224_BasicCalculator {
    
    public int calculate(String s) {
        
        char[] seq = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        
        int sum = 0;
        int sign = 1;
        char op = '+';

        for (int i = 0; i < seq.length; i++) {
            if (isNum(seq[i])) {
                int num = seq[i] - '0';
                while (i + 1 < seq.length && isNum(seq[i + 1])) {
                    num = num * 10 + (seq[i + 1] - '0');
                    i++;
                }
                num *= sign;
                sum = calculate(sum, op, num);
            }
            else if (seq[i] == '+' || seq[i] == '-') op = seq[i];
            else if (seq[i] == '(') {
                if (op == '+') stack.push(1);
                else {
                    sign *= -1;
                    stack.push(-1);
                }
                op = '+';
            }
            else if (seq[i] == ')') sign *= stack.pop();
        }
        
        return sum;
        
    }
    
    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
    
    private int calculate(int sum , char op, int num) {
        if (op == '+') return sum + num;
        return sum - num;
    }

}
