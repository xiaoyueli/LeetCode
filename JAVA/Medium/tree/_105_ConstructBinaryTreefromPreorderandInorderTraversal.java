package tree;

import java.util.HashMap;

/**
 * Given preorder and inorder traversal of a tree, 
 * construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * 中序遍历计算出左右子树起始位置
 */

class TreeNode {
    // Definition for a binary tree node.
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
    int[] pre;
    int[] inor;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        inor = inorder;
        map = new HashMap<Integer, Integer>();
        
        for (int idx = 0; idx < inor.length; idx++) {
            map.put(inor[idx], idx);
        }
        
        TreeNode root = buildTree(0, 0, inor.length - 1);

        return root;
    }
    
    public TreeNode buildTree(int root, int left, int right) {
        
        if (root >= pre.length) return null;
        if (left > right) return null;
        TreeNode rNode = new TreeNode(pre[root]);
        int idx = map.get(pre[root]);
        int len = idx - left;

        rNode.left = buildTree(root + 1, left, idx - 1);
        rNode.right = buildTree(root + len + 1, idx + 1, right);


        return rNode;
    }
}