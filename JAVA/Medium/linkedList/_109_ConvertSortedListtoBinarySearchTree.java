package linkedList;

/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 *
 * 找到中点递归左右子树
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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

public class _109_ConvertSortedListtoBinarySearchTree {
    
    public TreeNode sortedListToBST(ListNode head) {
        
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        if (pre != null) {
            pre.next = null;
            root.left = sortedListToBST(head);
        }
        
        root.right = sortedListToBST(slow.next);
        slow.next = null;
        
        return root;
        
    }
    
    
    ListNode node;
    public TreeNode sortedListToBST2(ListNode head) {
        
        if (head == null) return null;
        
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        
        node = head;
        TreeNode root = insert(0, len - 1);
        
        return root;
        
    }
    
    public TreeNode insert(int sta, int end) {
        if (sta > end) return null;
        
        int mid = (sta + end) / 2;
        
        TreeNode left = insert(sta, mid - 1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        TreeNode right = insert(mid + 1, end);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}
