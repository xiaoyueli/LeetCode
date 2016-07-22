package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree [1,null,2,3],
 * 
 * 1
    \
     2
    /
   3
 *
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * 先把左子树入栈，读数，
 * 再把右子树入栈
 * 
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return lst;
        stack.push(root);
        while (!stack.isEmpty()) {
            
            while (root != null && root.left != null) {
                stack.push(root.left);
                root = root.left;
            }

            TreeNode node = stack.pop();
            lst.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
                root = node.right;
            }            
        }
        return lst;
    }
}
