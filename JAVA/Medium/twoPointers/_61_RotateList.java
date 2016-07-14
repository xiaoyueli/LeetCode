package twoPointers;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * 向右移动K位后，list的后K个元素变为前K个元素，前len - k个元素变为后len - k个元素
 * 
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class _61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        int cnt = 1;
        ListNode rear = head;
        while (rear.next != null) {
            rear = rear.next;
            cnt++;
        }
        
        int step = k % cnt; // 第一个元素需要位移的步数 == 有多少元素需要被提前
        if (step == 0) return head;
        step = cnt - step; // 有多少元素需要被置后
        rear.next = head;
        rear = head;
        while (step > 1) {
            rear = rear.next;
            step--;
        }
        head = rear.next;
        rear.next = null;
        
        return head;
    }
}
