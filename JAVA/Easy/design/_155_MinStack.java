package design;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, 
 * and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.
    
 *  思路，
 *  法1： 用两个stack,一个正常保存。一个保存更新的最小值
 *  
 *  法2：用list 或者Array保存 array需要reallocate memory
 *  min 考虑heap 或者全局 min 
 *
 */

public class _155_MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public _155_MinStack() {
        
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
        
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) minStack.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
    // list + 全局Min
//    public class MinStack {
//
//        /** initialize your data structure here. */
//        class Node {
//            int val;
//            Node next;
//            
//            Node () {
//                val = 0;
//                next = null;
//            }
//            
//            Node (int val, Node nextNode) {
//                this.val = val;
//                next = nextNode;
//            }
//            
//        }
//        Node head;
//        int min;
//        public MinStack() {
//            head = null;
//            min = Integer.MAX_VALUE;
//        }
//        
//        public void push(int x) {
//            head = new Node(x, head);
//            if (x < min) min = x;
//        }
//        
//        public void pop() {
//            if (head != null) {
//                int val = head.val;
//                head = head.next;
//                if (val == min) min = findMin();
//            }
//        }
//        
//        private int findMin() {
//
//            Node temp = head;
//            min = Integer.MAX_VALUE;
//            while (temp != null) {
//                if (min > temp.val) min = temp.val;
//                temp = temp.next;
//            }
//            
//            return min;
//        }
//        
//        public int top() {
//            return head.val;
//        }
//        
//        public int getMin() {
//            return min;
//        }
//    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

}
