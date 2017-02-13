package linkedList;

import twoPointers.ListNode;

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
        
        ListNode cur = new ListNode(0);
        cur.next = head;
        head = cur;
        ListNode greater = new ListNode(0);
        ListNode headG = greater;
        
        while (cur.next != null) {
            if (cur.next.val < x) {
                cur = cur.next;
            }
            else {
                greater.next = cur.next;
                greater = cur.next;
                cur.next = cur.next.next;
                greater.next = null;
            }
        }
        headG = headG.next;
        cur.next = headG;
        
        return head.next;
        
    }
}