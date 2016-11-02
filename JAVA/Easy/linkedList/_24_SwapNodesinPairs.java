package linkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 *
 * 递归
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _24_SwapNodesinPairs {
    
    //递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode sec = head.next;
        head.next = swapPairs(sec.next);
        sec.next = head;
        head = sec;
        
        return head;
    }
    
    // 迭代
    public ListNode swapPairs2(ListNode head) {
        
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        ListNode cur = head;
        
        while (cur.next != null && cur.next.next != null) {
            
            temp = cur.next;
            cur.next = cur.next.next;
            temp.next = cur.next.next;
            cur.next.next = temp;
            cur = temp;
        }
        
        head = head.next;
        
        return head;
    }
}
