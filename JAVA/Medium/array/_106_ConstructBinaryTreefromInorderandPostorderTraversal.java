package array;

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
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] in;
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder;
        post = postorder;
        
        for (int idx = 0; idx < in.length; idx++) {
            map.put(in[idx], idx);
        }
        
        TreeNode root = buildTree(post.length - 1, 0, in.length - 1);
        
        return root;
    }
    
    public TreeNode buildTree(int root, int left, int right) {
        if (root < 0) return null;
        if (left > right) return null;
        TreeNode rNode = new TreeNode(post[root]);
        int idx = map.get(post[root]);
        int len = right - idx;
        rNode.left = buildTree(root - len - 1, left, idx - 1);
        rNode.right = buildTree(root - 1, idx + 1, right);
        return rNode;
    }
    
}
