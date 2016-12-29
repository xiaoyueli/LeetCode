package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author xiaoyue
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
    
    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [3,2,1].
    
    Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * 思路：
 * 先遍历右孩子，再遍历左孩子
 * 用LinkedList,每次将值插入表头
 * 
 */

public class _145_BinaryTreePostorderTraversal {
    
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (!stack.isEmpty() || root != null) {
            
            while (root != null) {
                stack.push(root);
                res.addFirst(root.val);
                root = root.right;
            }
            
            root = stack.pop();
            root = root.left;
        }
        
        return res;
      
    }

}
