package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree
 *  struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
 * 
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree 
 * (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 
 *       1
       /  \
      2    3
     / \  / \
    4  5  6  7
    
 * After calling your function, the tree should look like:
 *       1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 *
 * 
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
 }

public class _116_PopulatingNextRightPointersinEachNode {
    
    public void connect(TreeLinkNode root) {
        
        Queue<TreeLinkNode> que = new LinkedList<TreeLinkNode>();
        if (root == null) return;
        que.offer(root);
        int size = 1;
        
        while (!que.isEmpty()) {
            TreeLinkNode cur = que.poll();
            size--;
            if (cur.left != null) que.offer(cur.left);
            if (cur.right != null) que.offer(cur.right);
            if (size == 0) {
                cur.next = null;
                size = que.size();
            }
            else cur.next = que.peek();
        }
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
