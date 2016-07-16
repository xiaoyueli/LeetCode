package linkedList;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _21_MergeTwoSortedLists {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        ListNode newOne;
        if (l1.val > l2.val) {
            newOne = l2;
            l2 = l2.next;
        }
        else {
            newOne = l1;
            l1 = l1.next;
        }
        
        head = newOne;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newOne.next = l1;
                l1 = l1.next;
            }
            else {
                newOne.next = l2;
                l2 = l2.next;
            }
            newOne = newOne.next;
        }
        
        while (l1 != null) {
            newOne.next = l1;
            l1 = l1.next;
            newOne = newOne.next;
        }
        while (l2 != null) {
            newOne.next = l2;
            l2 = l2.next;
            newOne = newOne.next;
        }
        newOne.next = null;
        
        return head;
    }
}
