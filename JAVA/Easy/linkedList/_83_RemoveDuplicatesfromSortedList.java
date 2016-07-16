package linkedList;

/**
 * Given a sorted linked list, 
 * delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _83_RemoveDuplicatesfromSortedList {
    
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) return head;
        
        ListNode rear = head;
        while (rear.next != null) {
            if (rear.val == rear.next.val) {
                rear.next = rear.next.next;
            }
            else rear = rear.next;
        }
        
        return head;
    }
}
