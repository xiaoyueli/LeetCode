package tree;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node.
 *
 */

public class _111_MinimumDepthofBinaryTree {
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        int lHeight = minDepth(root.left);
        int rHeight = minDepth(root.right);
        
        if (lHeight == 0) return rHeight + 1;
        else if (rHeight == 0) return lHeight + 1;
        else return Math.min(lHeight, rHeight) + 1;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
