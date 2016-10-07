package tree;

/**
 * Invert a binary tree.
 *       4
       /   \
      2     7
     / \   / \
    1   3 6   9
 * 
 * to
 *       4
       /   \
      7     2
     / \   / \
    9   6 3   1
 *
 */

public class _226_InvertBinaryTree {
    
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        
        return root;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
