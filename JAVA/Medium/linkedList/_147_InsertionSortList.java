package linkedList;

/**
 * Sort a linked list using insertion sort.
 * 
 * 当前node比sorted list rear 大就加在rear上
 * 否则就从前开始遍历插入sorted list
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _147_InsertionSortList {
    
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode sorted = head;
        ListNode cur = head.next;
        ListNode rear = head;
        rear.next = null;
        while (cur != null) {
            if (cur.val >= rear.val) {
                rear.next = cur;
                rear = cur;
                cur = cur.next;
                rear.next = null;
            }
            else {
                ListNode temp = cur.next;
                sorted = insert(sorted, cur);
                cur = temp;
            }
        }
        return sorted;
    }
    
    public ListNode insert(ListNode head, ListNode node) {
        
        ListNode cur = head;
        ListNode pre = null;
    
        while (true) {
            
            if (node.val >= cur.val) {
                pre = cur;
                cur = cur.next;
            }
            else {
                if (pre == null) {
                    pre = node;
                    node.next = cur;
                    return pre;
                }
                pre.next = node;
                node.next = cur;
                return head;
            }
        }
    }
}
