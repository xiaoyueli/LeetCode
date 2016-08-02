package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 
 * But the following [1,2,2,null,3,null,3] is not:
 * 
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3    3
 *     
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * 这道题递归比迭代快
 * 思路，每次比较的两个Node, 异侧son需要相同，即 node1.left == node2.right
 * 
 * 
 *Definition for a binary tree node.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


public class _101_SymmetricTree {
    
    // iteratively
    public boolean isSymmetric(TreeNode root) {
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        
        if (root == null) return true;
        TreeNode lson = root.left;
        TreeNode rson = root.right;
        que.offer(lson);
        que.offer(rson);
        
        while (!que.isEmpty()) {
            lson = que.poll();
            rson = que.poll();
            if (lson == null && rson == null) continue;
            else if (lson == null || rson == null) return false;
            else if (lson.val != rson.val) return false;
            que.offer(lson.left);
            que.offer(rson.right);
            que.offer(lson.right);
            que.offer(rson.left);
        }
        
        return true;
        
    }
    
    
    // recursively
    public boolean isSymmetric2(TreeNode root) {

        if (root == null) return true;
        return compare(root.left, root.right);

    }
    
    public boolean compare(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        else if (a == null || b == null) return false;
        else if (a.val != b.val) return false;
        
        boolean outer = compare(a.left, b.right);
        boolean inner = compare(a.right, b.left);
        
        return outer && inner;
    }
}
