package stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Stack<Integer> stack = new Stack<Integer>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;
        que.offer(root);
        int size = 1;
        boolean reverse = false;
        List<Integer> sub = new ArrayList<Integer>();
        
        
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            size--;
            if (reverse) stack.push(cur.val);
            else sub.add(cur.val);
            
            if (cur.left != null) que.offer(cur.left);
            if (cur.right != null) que.offer(cur.right);
            
            if (size == 0) {
                size = que.size();
                reverse = !reverse;
                if (!sub.isEmpty()) {
                    res.add(sub);
                }
                else {
                    while (!stack.isEmpty()) {
                        sub.add(stack.pop());
                    }
                    res.add(sub);
                }
                sub = new ArrayList<Integer>();
            }
        }
        
        return res;
        
    }
}
