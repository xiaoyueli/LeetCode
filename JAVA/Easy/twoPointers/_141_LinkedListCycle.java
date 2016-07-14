package twoPointers;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 *
 * Definition for singly-linked list.
 * 
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { 
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class _141_LinkedListCycle {
    
    public boolean hasCycle(ListNode head) {
        
        ListNode other = head;
        
        while (head != null && other != null) {
            
            head = head.next;
            other = other.next;
            if (other == null) return false;
            other = other.next;
            if (head == other) return true;
            
        }
        
        return false;
    }
}
