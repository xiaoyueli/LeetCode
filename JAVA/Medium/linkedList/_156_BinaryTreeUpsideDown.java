package linkedList;

/**
 * 
 * @author xiaoyue
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 * (a left node that shares the same parent node) or empty, 
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. 
 * Return the new root.

    For example:
    Given a binary tree {1,2,3,4,5},
        1
       / \
      2   3
     / \
    4   5
    return the root of the binary tree [4,5,2,#,#,3,1].
       4
      / \
     5   2
        / \
       3   1  
 * 
 * /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 思路，把左边的sibling变为右孩子，把parent变为左孩子。自己成为右孩子的左孩子。递归
 * 
 */


public class _156_BinaryTreeUpsideDown {
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        
        if (root == null) return null;
        
        return helper(root, null, null);
        
    }
    
    private TreeNode helper(TreeNode root, TreeNode parent, TreeNode sibling) {
        if (root.left == null) {
            root.left = sibling;
            root.right = parent;
            return root;
        }
        
        TreeNode left = root.left;
        TreeNode newRoot = helper(root.left, root, root.right);

        
        root.left = sibling;
        root.right = parent;
        left.right = root;
        
        return newRoot;
        
    }

}
