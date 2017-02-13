package linkedList;

/**
 * Given a sorted linked list, 
 * delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class _82_RemoveDuplicatesfromSortedList2 {
    
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        ListNode rear = newHead;
        int cnt = 1;
        
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head = head.next;
                cnt++;
            }
            else {
                if (cnt == 1) {
                    rear.next = head;
                    rear = rear.next;
                }
                head = head.next;
                cnt = 1;
            }
        }
        
        if (cnt == 1) rear.next = head;
        else rear.next = null;
        
        return newHead.next;
    }
}
