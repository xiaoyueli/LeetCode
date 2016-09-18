package tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 */

public class _110_BalancedBinaryTree {
    
    public boolean isBalanced(TreeNode root) {
        
        if (root == null) return true;
        
        int diff = difference(root);
        
        if (diff == Integer.MAX_VALUE) return false;
        return true;
    }
    
    public int difference(TreeNode td) {
        if (td == null) return 0;
        if (td.left == null && td.right == null) return 1;
        
        int left = difference(td.left);
        if (left == Integer.MAX_VALUE) return left;
        int right = difference(td.right);
        if (right == Integer.MAX_VALUE) return right;
        if (Math.abs(left - right) <= 1) return Math.max(left, right) + 1;
        else return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
