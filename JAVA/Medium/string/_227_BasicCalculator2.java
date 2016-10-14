package string;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
 * The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid.
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * 
 * Note: Do not use the eval built-in library function.
 * 
 * 思路：
 * 用一个栈存数字
 * 用一个全局char 保存上一个操作符
 * 当再次遇到操作符时，如果上一个操作符是加减号，则将当前的数字加上相应的符号入栈
 * 如果上一个操作符是乘除号，就弹出栈顶数字与当前数字计算后入栈
 * 再将当前操作符更新为上一个操作符
 */

import java.util.Stack;

public class _227_BasicCalculator2 {

    public int calculate(String s) {
        
        char[] seq = s.toCharArray();
        int len = seq.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        int num = 0;
        char preOper = '+';
        for (int idx = 0; idx < len; idx++) {
            char cur = seq[idx];
            
            if (cur - '0' >= 0 && cur - '0' <= 9) {
                num = num * 10 + cur - '0';
            }
            
            if (isOper(cur) || idx == len - 1) {
            
                if (preOper == '+') stack.push(num);
                else if (preOper == '-') stack.push(-1 * num);
                else if (preOper == '*') stack.push(stack.pop() * num);
                else if (preOper == '/') stack.push(stack.pop() / num);
                preOper = cur;
                num = 0;
                
            }
        }
        
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
    
    private boolean isOper(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        String exp = "100000000/1 / 2/3*4/5-6/ 7+8/9/10";
//        String[] seq = exp.split(" |\\+|\\*|-|/");
        _227_BasicCalculator2 test = new _227_BasicCalculator2();
        
        test.calculate("5   ");
//       for (String s : seq) System.out.println(s);

    }

}
