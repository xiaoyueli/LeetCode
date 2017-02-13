package tree;

import java.util.HashMap;

/**
 * Given inorder and postorder traversal of a tree, 
 * construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, map, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] in, int[] post, HashMap<Integer, Integer> map, int root, int sta, int end) {
        if (root < 0) return null;
        if (sta > end) return null;
        
        TreeNode rNode = new TreeNode(post[root]);
        int len = map.get(post[root]);
        
        TreeNode left = helper(in, post, map, root - (end - len) - 1, sta, len - 1);
        TreeNode right = helper(in, post, map, root - 1, len + 1, end);
        
        rNode.left = left;
        rNode.right = right;
        
        return rNode;
    }
    
}
