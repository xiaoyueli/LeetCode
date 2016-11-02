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
 * 思路：
 * 假如把两个list分别前后拼接起来形成 AB, BA，则两个LIST的长度相等，且A和B相交的点到链尾的距离相等
 * 用两个指针分别一起遍历A和B，当A指针到达末尾时重定向到B链表头部，当B到达末尾时重定向到A头部
 * 当各自重定向一次后，会同时到达链尾，如果没有相同的元素，就没有交集
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
        
        ListNode la = headA;
        ListNode lb = headB;
        if (la == null || lb == null) return null;
        
        while (la != null && lb != null) {
            if (la.val == lb.val) return la;
            la = la.next;
            lb = lb.next;
            if (la == null && lb != null) la = headB;
            if (lb == null && la != null) lb = headA;
        }
        
        return null;
        
    }
}
