package linkedList;

/**
 * Reverse a linked list from position m to n. 
 * Do it in-place and in one-pass.
 * For example:
 * 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 * 指针指向m-1后从第M个node开始反转，
 * 需要反转的个数作为结束标签
 * 带两个指针变量，一个作为反转指针，一个作为连接后面node的指针
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _92_ReverseLinkedList2 {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if (m == 1) {
            head = reverse(head, head, n - m);
            return head;
        }
        
        ListNode cur = head;
        int cnt = 1;
        while (cnt < m - 1) {
            cur = cur.next;
            cnt++;
        }
        
        cur.next = reverse(cur.next, cur.next, n - m);
        
        return head;
    }
    
    public ListNode reverse(ListNode node, ListNode rear, int cnt) {
        if (cnt == 0) {
            rear.next = node.next;
            return node;
        }
        ListNode nextNode = node.next;
        ListNode newHead = reverse(node.next, rear, cnt - 1);
        nextNode.next = node;
        
        return newHead;
    }
}
