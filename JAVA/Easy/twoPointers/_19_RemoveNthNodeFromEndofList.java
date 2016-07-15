package twoPointers;

/**
 * Given a linked list, 
 * remove the nth node from the end of list and return its head.
 * 
 * For example,
 *    Given linked list: 1->2->3->4->5, and n = 2.
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 *    
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * 双指针，第二个指针与第一个指针相差N个元素，
 * 当第二个指针到达末尾时，第一个指针指向需要删除的元素N
 * 注意，当N正好为元素总数时，第一个指针为需要删除的元素
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _19_RemoveNthNodeFromEndofList {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {      

        ListNode sec = head;
        ListNode fir = head;
        while (n > 0) {
            sec = sec.next;
            n--;
        }

        while (sec != null && sec.next != null) {
            fir = fir.next;
            sec = sec.next;
        }
        
        ListNode temp;
        if (sec == null) {
            temp = head;
            head = head.next;
            temp.next = null;
        }
        else {
            temp = fir.next;
            fir.next = temp.next;
            temp.next = null; 
        }
        
        return head;
    }
}
