package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *      3
       / \
      9  20
        /  \
       15   7
       
 * return its bottom-up level order traversal as:
 * [
      [15,7],
      [9,20],
      [3]
    ]
/**
 * Definition for a binary tree node.
 *
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 */

public class _107_BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        Stack<List<Integer>> stack = new Stack<>();
        
        if (root == null) return res;
        
        que.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        int size = 1;
        
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            size--;
            list.add(cur.val);
            if (cur.left != null) que.offer(cur.left);
            if (cur.right != null) que.offer(cur.right);
            
            if (size == 0) {
                stack.push(list);
                list = new ArrayList<Integer>();
                size = que.size();
            }
        }
        
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        
        return res;
        
    }
}
