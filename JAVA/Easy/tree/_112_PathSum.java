package tree;

/**
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 *            5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 *       
 * return true, as there exist a root-to-leaf path 5->4->11->2 
 * which sum is 22.
 */

public class _112_PathSum {
    
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if (root == null) return false;
        
        return helper (root, 0, sum);
    }
    
    public boolean helper(TreeNode td, int curSum, int target) {
        if (td == null) return false;
        if (td.left == null && td.right == null) return (td.val + curSum) == target;
        
        boolean left = helper(td.left, td.val + curSum, target);
        boolean right = helper(td.right, td.val + curSum, target);
        
        return left || right;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
