package tree;

/**
 * 
 * @author xiaoyue
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".

    What if the given tree could be any binary tree? Would your previous solution still work?
    
    Note:
    
    You may only use constant extra space.
    For example,
    Given the following binary tree,
             1
           /  \
          2    3
         / \    \
        4   5    7
    After calling your function, the tree should look like:
             1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \    \
        4-> 5 -> 7 -> NULL
 * 
 */
/**
 * Definition for binary tree with next pointer.
 */
class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }

public class _117_PopulatingNextRightPointersinEachNode2 {
    
    public void connect(TreeLinkNode root) {
        
        TreeLinkNode pre = new TreeLinkNode(0);
        TreeLinkNode cur = pre;
        
        while (root != null) {
            TreeLinkNode pointer = root;
            
            while (pointer != null) {
                if (pointer.left != null) {
                    cur.next = pointer.left;
                    cur = cur.next;
                }
                if (pointer.right != null) {
                    cur.next = pointer.right;
                    cur = cur.next;
                }
                pointer = pointer.next;
            }
            
            root = pre.next;
            pre.next = null;
            cur = pre;
        } 
    }
}
