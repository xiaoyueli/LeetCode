package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * 
 * 利用二叉树递归思想：
 * 初始为左括号，每次分别添加左括号，和右括号
 * 舍弃右括号大于左括号的情况
 * 1：                                                                                 "("
 * 2:                 "(("                +                 "()" 
 * 3:        "((("      +     "(()"             "()("        +      "())" <右括号大于左，舍弃>
 * 4:   "((((" + "((()"   "(()(" + "(())"    "()((" + "()()"
 *
 */

public class _22_GenerateParentheses {
    
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<String>();
        char[] seq = new char[2 * n];
        
        helper(res, seq, 0, 0, 0, n);
        
        return res;
    }
    
    private void helper(List<String> res, char[] seq, int pos, int left, int right, int len) {
        if (left == len && right == len) {
            res.add(new String(seq));
            return;
        }

        if (left > len) return;
        if (right > left) return;
        
        seq[pos] = '(';
        helper(res, seq, pos + 1, left + 1, right, len);
        seq[pos] = ')';
        helper(res, seq, pos + 1, left, right + 1, len);
    }

}
