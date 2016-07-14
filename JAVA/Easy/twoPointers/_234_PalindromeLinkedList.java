package twoPointers;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * 反转后一半链表再比较
 *
 * Definition for singly-linked list.
 *
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class _234_PalindromeLinkedList {
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        int cnt = 1;
        ListNode rear = head;
        while (rear.next != null) {
            rear = rear.next;
            cnt++;
        }
        
        int step = cnt - cnt / 2;
        rear = head;
        while (step > 0) {
            rear = rear.next;
            step--;
        }
        
        rear = reverseList(rear);
        step = cnt / 2;
        while (step > 0) {
            if (head.val != rear.val) return false;
            head = head.next;
            rear = rear.next;
            step--;
        }
        
        return true;
        
    }
    
    public ListNode reverseList(ListNode head) {
        if (head.next == null) return head;
        
        ListNode rear = head.next;
        ListNode newHead = reverseList(head.next);
        rear.next = head;
        head.next = null;
        return newHead;
        
    }
}