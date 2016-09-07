package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 * 
 *     1
        \
         2
        /
       3
 * return [1,2,3].

 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();

        while (root != null || !stack.isEmpty()) {
            
            while (root != null) {               
                stack.push(root);
                res.add(root.val);
                root = root.left;              
            }

            root = stack.pop();
            root = root.right;          
        }
        
        return res;
        
    }
}
