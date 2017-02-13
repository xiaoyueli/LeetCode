package linkedList;

/**
 * Sort a linked list using insertion sort.
 * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _147_InsertionSortList {
    
    public ListNode insertionSortList(ListNode head) {
        
        if (head == null || head.next == null) return head;
        
        ListNode newHead = new ListNode(0);
        
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            insert(newHead, temp);
        }
        
        return newHead.next;
        
    }
    
    private void insert(ListNode head, ListNode node) {
        
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null && node.val > cur.val) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
    }
}
