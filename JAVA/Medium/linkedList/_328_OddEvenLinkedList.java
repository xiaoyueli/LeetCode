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
            
        ListNode odd = head;
        ListNode evenH = head.next;
        ListNode even = evenH;
        ListNode cur = evenH.next;
        
        while (cur != null && cur.next != null) {
            odd.next = cur;
            odd = odd.next;
            even.next = cur.next;
            even = even.next;
            cur = cur.next.next;
        }
        
        if (cur != null) {
            odd.next = cur;
            cur.next = evenH;
        }
        else {
            odd.next = evenH;
        }
        even.next = null;
        
        return head;
    }
    
}
