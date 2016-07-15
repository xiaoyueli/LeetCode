package twoPointers;

/**
 * Given a linked list and a value x, 
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _86_PartitionList {
    
    public ListNode partition(ListNode head, int x) {
        
        if (head == null || head.next == null) return head;
        ListNode greater = null;
        ListNode less = null;
        ListNode subHead = null;
        ListNode rear = head;
        while (rear != null) {
            if (rear.val < x && less == null) {
                less = rear;
                head = less;
            }
            else if (rear.val < x)  {
                less.next = rear;
                less = less.next;
            }
            else if (rear.val >= x && greater == null) {
                greater = rear;
                subHead = greater;
            }
            else if (rear.val >= x) {
                greater.next = rear;
                greater = greater.next;
            }
            rear = rear.next;
        }
        if (less == null) return subHead;
        less.next = subHead;
        if (greater != null) greater.next = null;
        return head;
    }
}