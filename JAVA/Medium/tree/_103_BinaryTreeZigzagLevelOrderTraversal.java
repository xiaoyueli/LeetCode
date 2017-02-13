package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import stack.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *      3
       / \
      9  20
        /  \
       15   7
       
   return its zigzag level order traversal as:
   
   [
      [3],
      [20,9],
      [15,7]
   ]
 *
 *
 *
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _103_BinaryTreeZigzagLevelOrderTraversal {
    
    // iteratively
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if (root == null) return res;
        que.offer(root);
        boolean reverse = false;
        while (!que.isEmpty()) {
            
            int size = que.size();
            List<Integer> ls = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                if (reverse) ls.add(0, cur.val);
                else ls.add(cur.val);
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
            res.add(ls);
            reverse = !reverse;
        }
        
        
        return res;
    }
    
    
    // recursively
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        helper(res, root, 0);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, TreeNode root, int level) {
        
        if (root == null) return;
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        
        if (level % 2 == 0) res.get(level).add(root.val);
        else res.get(level).add(0, root.val);
        
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
        
    }
}
