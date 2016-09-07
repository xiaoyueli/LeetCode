package divideAndConquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string of numbers and operators, 
 * return all possible results from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * 
 * Example 1
 * Input: "2-1-1".
 * 
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 
 * Output: [0, 2]
 * 
 * Example 2
 * Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * 
 * Output: [-34, -14, -10, -10, 10]
 * 
 * 遇到运算符时将运算式分为左右两边，分别递归求子运算式的结果
 * 再用该运算符分别计算左右子运算式。
 *
 */

public class _241_DifferentWaystoAddParentheses {
    
    char[] str;
    public List<Integer> diffWaysToCompute(String input) {

        str = input.toCharArray();
        int len = str.length;
        
        return helper(0, len - 1);
  
    }
    
    public List<Integer> helper(int sta, int end) {
        List<Integer> list = new ArrayList<Integer>();
        
        int num = 0;
        for (int idx = sta; idx <= end; idx++) {
            char cur = str[idx];
            if (isOper(cur)) {
                // 遇到运算符递归左右子运算式
                List<Integer> left = helper(sta, idx - 1);
                List<Integer> right = helper(idx + 1, end);
                
                for (int l: left) {
                    for (int r: right) {
                        list.add(compute(l, r, cur));
                    }
                }
            }
            else {
                // 处理连续遇到数字的情况
                num  = num * 10 + (cur - '0');
            }
            
        }
        
        // 子运算式中只有数字
        if (list.isEmpty()) list.add(num);
        
        
        return list;
    }
    
    public boolean isOper(char sign) {
        if (sign == '+' || sign == '-' || sign =='*') return true;
        return false;
    }
    
    public int compute(int a1, int a2, char op) {
        switch(op) {
            case '+':
                return a1 + a2;
            case '-':
                return a1 - a2;
            case '*':
                return a1 * a2;
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        _241_DifferentWaystoAddParentheses test = new _241_DifferentWaystoAddParentheses();
        test.diffWaysToCompute("11");

    }

}
