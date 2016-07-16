package linkedList;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class _2_AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode n1 = l1;
        ListNode n2 = l2;
        
        int add = 0;
        ListNode pre = null;
        while (n1 != null && n2 != null) {
            pre = n1;
            int sum = n1.val + n2.val;
            n1.val = (sum + add) % 10;
            n2.val = n1.val;
            add = (sum + add) / 10;
            n1 = n1.next;
            n2 = n2.next;
        }
        
        if (add == 0 && n1 != null) return l1;
        else if (add == 0) return l2;
        else if (add != 0 && n1 == null && n2 == null) {
            pre.next = new ListNode(add);
            return l1;
        }
        else if (add != 0 && n1 != null) {
            sumList(n1, add);
            return l1;
        }
        else {
            sumList(n2, add);
            return l2;
        }
    }
    
    public void sumList(ListNode node, int add) {
        ListNode pre = node;
        while (node != null) {
            pre = node;
            int sum = node.val + add;
            node.val = sum % 10;
            add = sum / 10;
            node = node.next;
        }
        if (add != 0) pre.next = new ListNode(add);
    }
}
