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
        ListNode cur = head;
        ListNode distin = new ListNode(0);
        head = distin;
        boolean flag = false;
        while (cur.next != null) {
            
            if (cur.val != cur.next.val && !flag) {
                distin.next = cur;
                distin = cur;
            }
            else if (cur.val != cur.next.val) flag = false;
            else flag = true;
            cur = cur.next;
        }
        
        if (!flag && cur != null) {
            distin.next = cur;
            distin = cur;
        }
        distin.next = null;
        
        head = head.next;
        
        return head;
        
    }
}
