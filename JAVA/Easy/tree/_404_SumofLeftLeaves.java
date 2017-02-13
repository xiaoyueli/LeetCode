package tree;

import java.util.Stack;

/**
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 *  3
   / \
  9  20
    /  \
   15   7
   
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */

public class _404_SumofLeftLeaves {
    
    public int sumOfLeftLeaves(TreeNode root) {

        return helper(root, 0, false);
        
    }
    
    public int helper(TreeNode td, int sum, boolean flag) {
        if (td == null) return sum;
        if (td.left == null && td.right == null && flag) {
            sum += td.val;
            return sum;
        }
        
        sum = helper(td.left, sum, true);
        sum = helper(td.right, sum, false);
        
        return sum;
        
    }
    
    
    // iteratively
    public int sumOfLeftLeaves1(TreeNode root) {
        
        int sum = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (root != null || !stack.isEmpty()) {
            
            TreeNode pre = root;
            TreeNode leaf = root;
            while (root != null) {
                stack.push(root);
                leaf = root;
                root = root.left;
            }
            
            
            if (leaf != pre && leaf.right == null) sum += leaf.val;
            
            root = stack.pop();
            root = root.right;
           
        }
        return sum;
        
    }

}
