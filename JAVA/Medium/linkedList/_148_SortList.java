package linkedList;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * merge sort
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class _148_SortList {
    
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow;
        slow = head;
        pre.next = null;
        
        ListNode sorted = merge(slow, fast);
        
        return sorted;
    }
    
    public ListNode merge(ListNode n1, ListNode n2) {
        n1 = sortList(n1);
        n2 = sortList(n2);
        ListNode sorted = new ListNode(0);
        ListNode cur = sorted;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                cur.next = n1;
                n1 = n1.next;
            }
            else {
                cur.next = n2;
                n2 = n2.next;
            }
            
            cur = cur.next;
        }
        
        while (n1 != null) {
            cur.next = n1;
            n1 = n1.next;
            cur = cur.next;
        }
        
        while (n2 != null) {
            cur.next = n2;
            n2 = n2.next;
            cur = cur.next;
        }
        
        return sorted.next;
        
    }
}
