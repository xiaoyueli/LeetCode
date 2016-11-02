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
        
        return helper(root, sum, 0);
        
    }
    
    private boolean helper(TreeNode root, int sum, int cur) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == cur + root.val;
        
        if (helper(root.left, sum, cur + root.val)) return true;
        return helper(root.right, sum, cur + root.val);
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
