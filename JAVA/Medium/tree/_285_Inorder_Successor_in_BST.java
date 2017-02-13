package tree;

import java.util.Stack;

/**
 * 
 * @author xiaoyue
 * 
 *  Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *  Note: If the given node has no in-order successor in the tree, return null.
 * 
 * 题意：找到大于所给节点的最小节点
 * 思路:和判断是否是有效二叉数一样，递归的时候跟新当前节点的有效范围
 * 如果当前节点=所找节点，且当前节点没有右孩子，返回它的有效最大值得节点
 * 否者找到它有孩子的最小左孩子，返回
 *
 */

public class _285_Inorder_Successor_in_BST {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        return helper(root, p, null, null);
        
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode min, TreeNode max) {
        
        if (root == p) {
            if (root.right == null) return max;
            root = root.right;
            while (root.left != null) root = root.left;
            return root;
        }
        
        if (p.val < root.val) return helper(root.left, p, min, root);
        return helper(root.right, p, root, max);
    }
    
    // iteratively
    public TreeNode solve(TreeNode root, TreeNode p) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        boolean isFound = false;
        while (root != null || !stack.isEmpty()) {
            
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (isFound) return root;
            if (root == p) isFound = true;
            root = root.right;
        }
        
        return null;
    }

}
