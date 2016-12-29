package linkedList;

/**
 * 
 * @author xiaoyue
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    Return a deep copy of the list.
 *
 * 思路：
 * 第一轮，在每个node后复制一个node连入链表
 * 第二轮，copy node 的random指向原node random的next.即为copy的node
 * 第三轮，把两个链表分开
 * 
 * 
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };

public class _138_CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) return null;
        
        RandomListNode cur = head;
        
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            RandomListNode temp = cur.next;
            cur.next = copy;
            copy.next = temp;
            cur = temp;
        }
        
        cur = head;
        while (cur != null) {
            RandomListNode copy = cur.next;
            if (cur.random == null) copy.random = null;
            else copy.random = cur.random.next;
            cur = copy.next;
        }
        
        RandomListNode copy = head.next;
        cur = head;
        while (cur != null) {
            RandomListNode temp = cur.next;
            cur.next = temp.next;
            cur = cur.next;
            if (cur != null) temp.next = cur.next;
        }
        
        return copy;
        
    }
}
