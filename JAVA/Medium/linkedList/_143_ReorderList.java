package linkedList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class _143_ReorderList {
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast == null) {
            fast = slow;
            pre.next = null;
        }
        else {
            fast = slow.next;
            slow.next = null;
        }
        slow = head;

        fast = reverse(fast);
        slow = head.next;
        head.next = fast;
        fast = fast.next;
        ListNode cur = head.next;
        while (slow != null && fast != null) {
            cur.next = slow;
            slow = slow.next;
            cur = cur.next;
            cur.next = fast;
            fast = fast.next;
            cur = cur.next;
        } 
        
        if (slow != null) cur.next = slow;

    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode newList = null;
        
        while (head != null) {
            ListNode temp = head.next;
            head.next = newList;
            newList = head;
            head = temp;
            
        }
              
        return newList;
    }
}
