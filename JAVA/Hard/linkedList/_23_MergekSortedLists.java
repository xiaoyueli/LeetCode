package linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 
 * @author xiaoyue
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * 1，用优先队列
 * 2. 用que, 每次merge 2个list. 再加入que.直到q只有一个list
 *
 */

public class _23_MergekSortedLists {
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        
        for (ListNode ln: lists) {
            if (ln != null) pq.offer(ln);
        }
        
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            cur.next = min;
            min = min.next;
            cur = cur.next;
            if (min != null && !pq.isEmpty()) pq.offer(min);
        }
        
        head = head.next;
        return head;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        

    }

}
