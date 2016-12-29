package linkedList;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. 
 * The program should run in O(1) space complexity and O(nodes) time complexity.
 * 
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * 
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input. 
 * The first node is considered odd, the second node even and so on ...
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _328_OddEvenLinkedList {
    
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null || head.next == null) return head;
        
        ListNode cur = head;
        ListNode oddT = cur;
        ListNode evenH = new ListNode(0);
        ListNode evenT = evenH;
        
        while (cur != null && cur.next != null) {
            oddT = cur;
            evenT.next = cur.next;
            evenT = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        
        evenT.next = null;
        evenH = evenH.next;
        if (cur != null) cur.next = evenH;
        else oddT.next = evenH;
        
        return head;     
        
    }
    
}
