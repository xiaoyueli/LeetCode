package reservoirSampling;

import java.util.Random;

/**
 * Given a singly linked list, 
 * return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * 
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? 
 * Could you solve this efficiently without using extra space?
 * 
 * Example:
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * 
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();

 * @author xiaoyue
 * 
 * 思路：
 * 关键是计算概率
 * 每次遍历整个链表
 * 计算概率的时候根据已经遍历到的节点个数n计算，用随机函数取在0-N中取值，另目标值为0，如果取到，则把当前值保存/更新为备选答案
 * 然后继续遍历剩下的节点
 * 
 * 最后的返回的值即为等概率选到的值
 * 因为如果该答案没有被之后的值覆盖，说明之后的值都没有选到这个值
 * 而该节点前也没有选到这个值，即为等概率
 * 
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
 
public class _382_LinkedListRandomNode {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    
    ListNode head;
    public _382_LinkedListRandomNode(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int cnt = 1;
        Random rand = new Random();
        ListNode temp = head;
        int res = 0;
        while (temp != null) {
            
            if (rand.nextInt(cnt) == 0) res = temp.val;
            cnt++;
            temp = temp.next;
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
