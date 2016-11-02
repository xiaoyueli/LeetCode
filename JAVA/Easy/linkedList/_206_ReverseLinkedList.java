package linkedList;

/**
 * Definition for singly-linked list.
 * Three pointer

 * rear tracks the old head
 * subhead tracks the head of the left list
 * which should be lifted up to be the new head
 */
class ListNode {
     int val;
    ListNode next;
     ListNode(int x) { val = x; }
}

public class _206_ReverseLinkedList {
    
    public ListNode reverseList(ListNode head) {
        
        if (head == null) return null;
        ListNode ls = null;
        
        while (head != null) {
            ListNode temp = head.next;
            head.next = ls;
            ls = head;
            head = temp;
        }
        
        return ls;
        
    }
}
