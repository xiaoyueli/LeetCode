package stack;

import java.util.Stack;

/**
 * One way to serialize a binary tree is to use pre-order traversal. 
 * When we encounter a non-null node, we record the node's value. 
 * If it is a null node, we record using a sentinel value such as #.
 * 
 *       _9_
        /   \
       3     2
      / \   / \
     4   1  #  6
    / \ / \   / \
    # # # #   # #
 * 
 * For example, the above binary tree can be serialized to the string 
 * "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * 
 * Given a string of comma separated values, 
 * verify whether it is a correct preorder traversal serialization of a binary tree. 
 * Find an algorithm without reconstructing the tree.
 * 
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, 
 * for example it could never contain two consecutive commas such as "1,,3".
 * 
 * Example 1:
    "9,3,4,#,#,1,#,#,2,#,6,#,#"
    Return true
    
    Example 2:
    "1,#"
    Return false
    
    Example 3:
    "9,#,#,1"
    Return false
 *
 *   
 *   思路：
 *   遇到数字就进栈
 *   遇到"#"时判断栈顶是不是"#" 如果是，则将与之对应的叶结点（数字）pop掉替换成"#"
 *   即每遇到两个连续"#"就将与之对应的数字叶子结点出栈，再入栈"#"代之
 *   
 *   最后栈内应该只有一个元素“#” 否则就不是合法二叉树
 */

public class _331_VerifyPreorderSerializationofaBinaryTree {
    
    public boolean isValidSerialization(String preorder) {
        
        String[] str = preorder.split(",");
        int len = str.length;
        Stack<String> stack = new Stack<String>();

        for (int idx = 0; idx < len; idx++) {
            String cur = str[idx];
            if (!cur.equals("#")) stack.push(cur); // 遇到数字进栈
            else {
                // 当遇到"#"时，如果栈顶是"#"，则将栈顶"#" 和 与之对应的叶结点（数字）pop出队列
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) return false;
                    else if (stack.peek().equals("#")) return false;
                    else stack.pop();
                }
                
                stack.push("#"); // 将被pop出的叶结点（数字）替换成"#"
                
            }
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
