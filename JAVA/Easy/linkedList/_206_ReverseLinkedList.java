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
        
        if (head == null) return head;
        
        ListNode rear = head;
        ListNode subHead = head.next;
        while (subHead != null) {
            rear.next = subHead.next;
            subHead.next = head;
            head = subHead;
            subHead = rear.next;
        }
        return head;
    }
}
