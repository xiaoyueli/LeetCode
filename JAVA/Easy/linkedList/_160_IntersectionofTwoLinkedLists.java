package linkedList;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * A:     a1 → a2
                                               ↘
                    c1 → c2 → c3
                                               ↗            
 * B: b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * 这道题题意不够清楚，根据网上的解法，该题目默认前提：
 * 如果两个List有交集，则交集必定在两个List的后半段，而不会出现在中间或前面，且相交后 不会
 * 出现不同的Node， 即交集是连续的
 * 
 * 则，如果有交集，从两个List从后往前必定有相同元素
 * 所以将两个List拼在一起，他们走的路程就等长，第一次遇到相同元素的地方就是交集开始的地方
 * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class _160_IntersectionofTwoLinkedLists {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode curA = headA;
        ListNode curB = headB;
        
        while (curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }
        if (curA == null) curA = headB;
        if (curB == null) curB = headA;
        
        while (curA != null && curB != null) {
            if (curA.val == curB.val) return curA;
            curA = curA.next;
            curB = curB.next;
            if (curA == null && curB != null) curA = headB;
            if (curB == null && curA != null) curB = headA;
        }
        
        return null;
    }
}
