package stack;

import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers represented as a string, 
 * implement a parser to deserialize it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * 
 * Note: You may assume that the string is well-formed:
 * 
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * 
 * Example 1:
 * Given s = "324",
 * You should return a NestedInteger object which contains a single integer 324.
 * 
 * Example 2:
 * Given s = "[123,[456,[789]]]",
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.
 *
 *
 *
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 * 
 * 
 * 遇到[ 进栈新的NestedInteger(NI)
 * 遇到，] 结束数字的读取： 
 * 如果是, 则将数字对象加入栈顶NI
 * 如果是] 则将栈顶NI出栈后加入下一个栈顶NI
 * 
 */

public class _385_MiniParser {
    
    

    public NestedInteger deserialize(String s) {
        
        char[] str = s.toCharArray();
        int len = str.length;
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        
        
        NestedInteger res = new NestedInteger();
        if (str[0] != '[') {
            res.setInteger(Integer.parseInt(s));
            return res;
        }
        
        int sta = -1; // 数字开始的位子

        for (int idx = 0; idx < len; idx++) {
            char cur = str[idx];
            if (isNum(cur) && sta == -1) sta = idx; //如果是数字，记录数字开始的地方
            else if (cur == '[') {
                // 进栈新的NI对象
                stack.push(new NestedInteger());
            }
            else if (cur == ',' || cur == ']') {
                NestedInteger top = stack.peek();
                if (sta != -1) {
                    // 之前有读取到数字，在栈顶加入数字NI
                    top.add(new NestedInteger(Integer.parseInt(s.substring(sta, idx))));
                    sta = -1; 
                }
                if (cur == ']') {
                    stack.pop(); // topNI 出栈
                    if (stack.isEmpty()) return top;
                    stack.peek().add(top); // 加出栈的top重新连接到新的topNI
                }
            }
            
        }
        
        return stack.peek();

    }

    
    public boolean isNum(char c) {
        int val = c - '0';
        if (val <= 9 && val >= 0 || c == '-') return true;
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
