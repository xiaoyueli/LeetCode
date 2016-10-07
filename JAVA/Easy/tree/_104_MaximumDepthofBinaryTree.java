package tree;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 *
 */

public class _104_MaximumDepthofBinaryTree {
    
    public int maxDepth(TreeNode root) {
        
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);
        

        return Math.max(lHeight, rHeight) + 1;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
