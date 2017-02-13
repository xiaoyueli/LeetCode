package tree;

/**
 * 
 * @author xiaoyue
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
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
 */

public class _156_BinaryTreeUpsideDown {
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode head = null;
        TreeNode pre = null;
        TreeNode sibling = null;
        
        while (root != null) {
            head = root.left;
            
            root.left = sibling;
            sibling = root.right;
            root.right = pre;
            pre = root;
            if (head == null) return root;
            root = head;
        }
        
        return root;
    }

}
