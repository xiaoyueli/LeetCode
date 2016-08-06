package design;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 
 * Notes:
 * You must use only standard operations of a stack 
 * -- which means only push to top, peek/pop from top, size, 
 * and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. 
 * You may simulate a stack by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a stack.
 * You may assume that all operations are valid 
 * (for example, no pop or peek operations will be called on an empty queue).
 *
 *  建两个栈
 *  一个栈用来push,
 *  pop时如果第二个栈为空，则将第一个栈的元素pop到第二个栈，然后再从第二个栈pop
 */

public class _232_ImplementQueueusingStacks {
    
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> que = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (que.isEmpty()) {
           while (!stack.isEmpty()) que.push(stack.pop());
        }
        que.pop();
    }

    // Get the front element.
    public int peek() {
        if (que.isEmpty()) {
            while (!stack.isEmpty()) que.push(stack.pop());
        }
       return que.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return que.isEmpty() && stack.isEmpty();
    }
    
    // 方法二，保持一个stack为空
//    Stack<Integer> stack = new Stack<Integer>();
//    Stack<Integer> que = new Stack<Integer>();
//    // Push element x to the back of queue.
//    public void push(int x) {
//        while (!que.isEmpty()) stack.push(que.pop());
//        stack.push(x);
//        while (!stack.isEmpty()) que.push(stack.pop());
//        
//    }
//
//    // Removes the element from in front of queue.
//    public void pop() {
//        que.pop();
//    }
//
//    // Get the front element.
//    public int peek() {
//       return que.peek();
//    }
//
//    // Return whether the queue is empty.
//    public boolean empty() {
//        return que.isEmpty();
//    }

}
