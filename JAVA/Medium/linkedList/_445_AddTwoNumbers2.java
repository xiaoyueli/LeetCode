package linkedList;

/**
 * 
 * @author xiaoyue
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * 
 * 如果不能修改LIST,就用数组
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _445_AddTwoNumbers2 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int len1 = count(l1);
        int len2 = count(l2);
        
        int[] seq1 = null;
        int[] seq2 = null;
        if (len1 > len2) {
            seq1 = new int[len1];
            seq2 = new int[len1];
            populate(l1, seq1, 0);
            populate(l2, seq2, len1 - len2);
        }
        else {
            seq1 = new int[len2];
            seq2 = new int[len2];
            populate(l1, seq1, len2 - len1);
            populate(l2, seq2, 0);
            
        }
        
        int len = seq1.length;
        int carry = 0;
        ListNode res = null;
        for (int idx = len - 1; idx >= 0; idx--) {
            ListNode temp = new ListNode((seq1[idx] + seq2[idx] + carry) % 10);
            carry = (seq1[idx] + seq2[idx] + carry) / 10;
            temp.next = res;
            res = temp;
        }
        
        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            temp.next = res;
            res = temp;
        }
        
        return res;
    }
    
    private void populate(ListNode ls, int[] seq, int num) {
        
        int len = seq.length;
        for (int idx = num; idx < len; idx++) {
            seq[idx] = ls.val;
            ls = ls.next;
        }
    }
    
    private int count(ListNode list) {
        int cnt = 0;
        while (list != null) {
            list = list.next;
            cnt++;
        }
        return cnt;
    }
      
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        
//        int len1 = count(l1);
//        int len2 = count(l2);
//        
//        if (len1 < len2) l1 = addNode(l1, len2 - len1);
//        else if (len1 > len2) l2 = addNode(l2, len1 - len2);
//        
//        int carry = helper(l1, l2);
//        ListNode res = l1;
//        if (carry != 0) {
//            res = new ListNode(carry);
//            res.next = l1;
//        }
//        return res;
//    }
    
    
    
//    private int helper(ListNode l1, ListNode l2) {
//        if (l1.next == null && l2.next == null) {
//            int val = (l1.val + l2.val) % 10;
//            int carry = (l1.val + l2.val) / 10;
//            l1.val = val;
//            return carry;
//        }
//        
//        int carry = helper(l1.next, l2.next);
//        int val = (l1.val + l2.val + carry) % 10;
//        int newCarry = (l1.val + l2.val + carry) / 10;
//        l1.val = val;
//        return newCarry;
//    }
    
 
//    private ListNode addNode(ListNode list, int num) {
//        
//        while (num != 0) {
//            ListNode temp = new ListNode(0);
//            temp.next = list;
//            list = temp;
//            num--;
//        }
//        
//        return list;
//    }
    
    
}
