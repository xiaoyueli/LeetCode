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
    
    List<String> res;
    int target;
    public List<String> generateParenthesis(int n) {
        target = n;
        res = new ArrayList<String>();
        addPar(1, 0, "(");
        return res;
    }
    
    public void addPar(int left, int right, String s) {
        if (left == right && left == target) {
            res.add(s);
            return;
        }

        if (left > target) return;
        if (right > left) return;
        
        addPar(left + 1, right, s + "(");
        addPar(left, right + 1, s + ")");
        
    }

}
