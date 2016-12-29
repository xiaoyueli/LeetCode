package tree;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    Note: 
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
    
    Follow up:
    What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
    How would you optimize the kthSmallest routine?
    
    Hint:
    
    Try to utilize the property of a BST.
    What if you could modify the BST node's structure?
    The optimal runtime complexity is O(height of BST).
 * 
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class _230_KthSmallestElementinaBST {
    
    // inorder travel;
    public int kthSmallest1(TreeNode root, int k) {
        
        int cnt = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            cnt++;
            if (cnt == k) break;
            root = root.right;
        }
        
        return root.val;
    }
    
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
