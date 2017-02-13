package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node.
 *
 */

public class _111_MinimumDepthofBinaryTree {
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null) left = minDepth(root.left) + 1;
        if (root.right != null) right = minDepth(root.right) + 1;
        
        return Math.min(left, right);
        
    }
    
    // iteratively
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int size = 1;
        int level = 1;
        
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            size--;
            if (cur.left == null && cur.right == null) return level;
            if (cur.left != null) que.offer(cur.left);
            if (cur.right != null) que.offer(cur.right);
            if (size == 0) {
                level++;
                size = que.size();
            }
        }
        
        return level;
  
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
