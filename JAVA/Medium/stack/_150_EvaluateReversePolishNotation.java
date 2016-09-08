package stack;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */

public class _150_EvaluateReversePolishNotation {
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = tokens.length;
        for (int idx = 0; idx < len; idx++) {
            String cur = tokens[idx];
            if (isOper(cur)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = compute(num1, num2, cur);
                stack.push(res);
            }
            else stack.push(Integer.parseInt(cur));
        }
        
        return stack.pop();
        
    }
    
    public boolean isOper(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) return true;
        return false;
    }
    
    public int compute(int num1, int num2, String oper) {
        switch(oper) {
            case "+" : return num1 + num2;
            case "-" : return num1 - num2;
            case "*" : return num1 * num2;
            case "/" : return num1 / num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
