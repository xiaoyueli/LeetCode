package tree;

/**
 * Definition for a binary tree node.
 * 
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class _230_KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        
        if (root == null) return 0;
        int sonNum = find(root.left);
        if (sonNum + 1 == k) return root.val;
        if (sonNum >= k) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - sonNum - 1);
    }
    
    public int find (TreeNode root) {
        if (root == null) return 0;
        int sonNum = find (root.left) + find(root.right) + 1;
        return sonNum;
    }
}
