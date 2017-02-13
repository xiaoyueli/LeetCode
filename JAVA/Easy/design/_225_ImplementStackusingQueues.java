package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * Notes:
 * You must use only standard operations of a queue -- 
 * which means only push to back, peek/pop from front, size, 
 * and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. 
 * You may simulate a queue by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, 
 * no pop or top operations will be called on an empty stack).
 *
 */

public class _225_ImplementStackusingQueues {
    
    // 方法1，pop的时候，将q1中的元素导入q2,最后一个元素poll掉
    // 保持q2为空
    // Push element x onto stack.
    Queue<Integer> que1 = new LinkedList<Integer>();
    Queue<Integer> que2 = new LinkedList<Integer>();
    int top = 0;
    public void push(int x) {
        que1.offer(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (que1.size() != 1) {
            top = que1.poll();
            que2.offer(top);
            
        }
        que1.poll();
        Queue<Integer> empQ = que1;
        que1 = que2;
        que2 = empQ;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return que1.isEmpty();
    }
    
    
    // 方法二，用一个que，每次push的时候，将前面的数字poll出再重新加入que

    // Push element x onto stack.
//    Queue<Integer> que = new LinkedList<Integer>();
//
//    public void push(int x) {
//        que.offer(x);
//        
//        for (int i = 0; i < que.size() - 1; i++) {
//            que.offer(que.poll());
//        }
//    }
//
//    // Removes the element on top of the stack.
//    public void pop() {
//        que.poll();
//    }
//
//    // Get the top element.
//    public int top() {
//        return que.peek();
//    }
//
//    // Return whether the stack is empty.
//    public boolean empty() {
//        return que.isEmpty();
//    }

}
