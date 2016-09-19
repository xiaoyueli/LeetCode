package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
 * 
 *     1            <---
     /   \
    2     3         <---
     \     \
      5     4       <---
 *     
 * You should return [1, 3, 4].
 * 
 * 思路：
 * 层序遍历取最后一个数
 */

public class _199_BinaryTreeRightSideView {
    
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (root == null) return res;
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int size = 1;
        
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            size--;
            if (cur.left != null) que.offer(cur.left);
            if (cur.right != null) que.offer(cur.right);
            
            if (size == 0) {
                res.add(cur.val);
                size = que.size();
            }
        }
        
        return res;
        
    }

}
