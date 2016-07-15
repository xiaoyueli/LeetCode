package twoPointers;

/**
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 *
 * 快慢指针，如果有环，快慢指针相遇时，快指正走过的路程是慢指针的两倍
 * 且快指针比慢指针多走一个整环的距离
 * 慢指针走的路程 = 开始到环开始的地方+ 环开始的地方到相遇的地方
 * 快指针多走的路程 = 相遇的地方到环开始的地方 + 环开始的地方到相遇的地方
 * 
 * 因此 当相遇后，让慢指针回到开始，快指针从相遇的地方同步调出发
 * 再次相遇的地方就是环开始的地方
 *
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class _142_LinkedListCycle2 {
    
    public ListNode detectCycle(ListNode head) {
        
        if (head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) return null;
            if (slow == fast) break;
        }
        
        if (fast.next == null) return null;
        
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
        
    }
}