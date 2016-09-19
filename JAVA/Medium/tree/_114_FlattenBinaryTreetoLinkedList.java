package tree;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 * 
 *       1
        / \
       2   5
      / \   \
     3   4   6
 *    
 * The flattened tree should look like:
 * 
 * 1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * 
 * 思路：
 * 把左子树接到右子树
 * 把右子树再街道已经被接到右边的左子树后
 * 递归函数返回值为flatten后的最后一个结点
 */

public class _114_FlattenBinaryTreetoLinkedList {
    
    public void flatten(TreeNode root) {
        
        if (root == null) return;
        
        helper(root);
        
    }
    
    public TreeNode helper(TreeNode td) {
        if (td == null) return null;
        if (td.left == null && td.right == null) return td;
        if (td.left == null) return helper(td.right);
        if (td.right == null) {
            td.right = td.left;
            td.left = null;
            return helper(td.right);
        }
        
        TreeNode temp = td.right;
        td.right = td.left;
        td.left = null;
        TreeNode link = helper(td.right);
        link.right = temp;
        
        return helper(temp);
        
        
        
    }

}
