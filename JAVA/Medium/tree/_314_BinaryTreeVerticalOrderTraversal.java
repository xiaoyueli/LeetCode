package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

    If two nodes are in the same row and column, the order should be from left to right.
    
    Examples:
    
    Given binary tree [3,9,20,null,null,15,7],
       3
      /\
     /  \
     9  20
        /\
       /  \
      15   7
    return its vertical order traversal as:
    [
      [9],
      [3,15],
      [20],
      [7]
    ]
    Given binary tree [3,9,8,4,0,1,7],
         3
        /\
       /  \
       9   8
      /\  /\
     /  \/  \
     4  01   7
    return its vertical order traversal as:
    [
      [4],
      [9],
      [3,0,1],
      [8],
      [7]
    ]
    Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
         3
        /\
       /  \
       9   8
      /\  /\
     /  \/  \
     4  01   7
        /\
       /  \
       5   2
    return its vertical order traversal as:
    [
      [4],
      [9,5],
      [3,0,1],
      [8,2],
      [7]
    ]
 * 
 * 思路，用2个Q和hashMap，
 * 一个Q存treeNode, 一个存该treeNode的idx. 同时出队入队
 * 另leftson的IDX 为当前-1，right为当前+1
 * 记录最大最小idx
 * map, idx与node
 * 
 * loop min to max. map取node,加入list
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
public class _314_BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<Integer> qIdx = new LinkedList<Integer>();
        Queue<TreeNode> qNode = new LinkedList<TreeNode>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        qIdx.offer(0);
        qNode.offer(root);
        
        int min = 0;
        int max = 0;
        while (!qNode.isEmpty()) {
            TreeNode cur = qNode.poll();
            int idx = qIdx.poll();
            if (!map.containsKey(idx)) map.put(idx, new ArrayList<Integer>());
            map.get(idx).add(cur.val);
            
            if (cur.left != null) {
                qNode.offer(cur.left);
                qIdx.offer(idx - 1);
                if (idx - 1 < min) min = idx - 1;
            }
            if (cur.right != null) {
                qNode.offer(cur.right);
                qIdx.offer(idx + 1);
                if (idx + 1 > max) max = idx + 1;
            }
        }
        
        
        for (int idx = min; idx <= max; idx++) {
            res.add(map.get(idx));
        }
        
        return res;
    }
    
}
