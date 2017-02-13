package linkedList;

/**
 * Reverse a linked list from position m to n. 
 * Do it in-place and in one-pass.
 * For example:
 * 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _92_ReverseLinkedList2 {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode cur = head;
        ListNode pre = null;
        int cnt = 1;
        while (cnt < m) {
            pre = cur;
            cur = cur.next;
            cnt++;
        }
        
        ListNode tempHead = cur;
        
        while (cnt < n) {
            cur = cur.next;
            cnt++;
        }
        
        ListNode rear = cur.next;
        cur.next = null;
        
        if (pre == null) head = reverse(tempHead);
        else pre.next = reverse(tempHead);
        
        tempHead.next = rear;
        
        return head;
        
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sec = head.next;
        ListNode newHead = reverse(sec);
        sec.next = head;
        head.next = null;
        return newHead;
    }
}
