package tree;

/**
 * 
 * @author xiaoyue
 * 
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 * 
 * For example,
 * 
     * 1
        \
         3
        / \
       2   4
            \
             5
     Longest consecutive sequence path is 3-4-5, so return 3.
       2
        \
         3
        / 
       2    
      / 
     1
    Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 *
 * 思路：
 * 比较child 和 parent的vale决定递归时归1.或+1
 * 用全局变量track最大值
 */

public class _298_BinaryTreeLongestConsecutiveSequence {

    int max = 0;
    public int longestConsecutive(TreeNode root) {
        
        if (root == null) return 0;
        
        helper(root, 1);
        
        return max;
        
    }
    
    private void helper(TreeNode root, int cnt) {
        if (cnt > max) max = cnt;
        
        if (root.left == null && root.right == null) return;
        
        int val = root.val;
        
        if (root.left != null && root.left.val - 1 == val) helper(root.left, cnt + 1);
        else if (root.left != null) helper(root.left, 1);
 
        if (root.right != null && root.right.val - 1 == val) helper(root.right, cnt + 1);
        else if (root.right != null) helper(root.right, 1);
        
    }
    

}
