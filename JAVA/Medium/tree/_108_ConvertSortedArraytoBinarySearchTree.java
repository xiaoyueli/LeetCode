package tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author xiaoyue
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        int len = nums.length;
        if (len == 0) return null;
        return helper(nums, 0, len - 1);
        
    }
    
    private TreeNode helper(int[] nums, int left , int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        
        int mid = left + (right - left) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        
        return root;
    }
}
