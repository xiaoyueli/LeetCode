package tree;

import java.util.Stack;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: 
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
 * that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 *      _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
 * 
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
 * Another example is LCA of nodes 5 and 4 is 5, 
 * since a node can be a descendant of itself according to the LCA definition
 * 
 * 比较的是实例，不是value.
 * 
 */

public class _236_LowestCommonAncestorofaBinaryTree {
    
    // 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null || p == null || q == null) return null;
        
        if (root == p) return p;
        if (root == q) return q;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        if (left == null && right == null) return null;
        if (left == null) return right;
        else return left;
        
        
    }
    
    // 用栈找路径
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null || p == null || q == null) return null;
        
        Stack<TreeNode> sp = new Stack<TreeNode>();
        Stack<TreeNode> sq = new Stack<TreeNode>();
        
        
        path(root, p, sp);
        path(root, q, sq);
        
        TreeNode res = root;
        
        while (!sp.isEmpty() && !sq.isEmpty() && sp.peek() == sq.peek()) {
            res = sp.pop();
            sq.pop();
        }
        
        return res;
        
    }
    
    private boolean path(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null) return false;
        if (root == node) return true;
        
        boolean found = path(root.left, node, stack);
        if (found) {
            stack.push(root.left);
            return true;
        }
        found = path(root.right, node, stack);
        if (found) {
            stack.push(root.right);
            return true;
        }
        
        return false;
        
    }

}
