package linkedList;

/**
 * 
 * @author xiaoyue
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * 思路：
 * 反转前K个node后
 * 递归后面的list
 *
 */

public class _25_ReverseNodesin_k_Group {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null) return null;
        
        int len = count(head);
        if (len < k) return head;
        
        ListNode rear = head;
        ListNode cur = null;
        
        int cnt = 0;
        while (cnt < k) {
            ListNode temp = head.next;
            head.next = cur;
            cur = head;
            head = temp;
            cnt++;
        }
        
        rear.next = reverseKGroup(head, k);
        
        return cur;
        
    }
    
    private int count(ListNode node) {
        int cnt = 0;
        while (node != null) {
            node = node.next;
            cnt++;
        }
        return cnt;
    }

}
