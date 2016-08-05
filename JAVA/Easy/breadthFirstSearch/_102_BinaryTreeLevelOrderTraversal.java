package breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, 
 * return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 * 
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 * 
 * #
 * 
 * Definition for a binary tree node.
 * 
 *
 *class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 */

public class _102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);

        int size = 1;
        List<Integer> list = new ArrayList<Integer>();
        
        while (!que.isEmpty()) {
            
            TreeNode cur = que.poll();
            size--;
            list.add(cur.val);

            TreeNode lson = cur.left;
            TreeNode rson = cur.right;
            if (lson != null) que.offer(lson);
            if (rson != null) que.offer(rson);
            
            if (size == 0) {
                res.add(list);
                list = new ArrayList<Integer>();
                size = que.size();
            }
        }
        
        return res;
    }
}
