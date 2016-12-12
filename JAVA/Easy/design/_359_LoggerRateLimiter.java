package design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author xiaoyue
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

    Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
    
    It is possible that several messages arrive roughly at the same time.
    
    Example:
    
    Logger logger = new Logger();
    
    // logging string "foo" at timestamp 1
    logger.shouldPrintMessage(1, "foo"); returns true; 
    
    // logging string "bar" at timestamp 2
    logger.shouldPrintMessage(2,"bar"); returns true;
    
    // logging string "foo" at timestamp 3
    logger.shouldPrintMessage(3,"foo"); returns false;
    
    // logging string "bar" at timestamp 8
    logger.shouldPrintMessage(8,"bar"); returns false;
    
    // logging string "foo" at timestamp 10
    logger.shouldPrintMessage(10,"foo"); returns false;
    
    // logging string "foo" at timestamp 11
    logger.shouldPrintMessage(11,"foo"); returns true;
 * 
 * 
 * 思路：
 * 自定义node存时间戳，用hashSet存相同时间的message
 * 用que<Node> 存node
 * hashSet<String> 存被打印过的message
 * 
 * 每次调用，先chcek时间戳，将超过10秒的node 即被打印过的message移除
 * 然后判断新的message是否被打印过，如果被打印过，enque只含时间戳的node
 * 若未被答应过，先判断最后的node是否时间相同，相同加入上一个node的message set.否者新开一个node ,然后将message加入printed set.
 */

class Node {
    
    int timestamp;
    HashSet<String> messages;
    
    public Node (int val) {
        timestamp = val;
        messages = new HashSet<String>();
    }
    
    public boolean sameTime(int time) {
        return timestamp == time;
    }
    
    public void addMessage(String message) {
        messages.add(message);
    }
    
    public HashSet<String> getMessages() {
        return messages;
    }
    
    public int time() {
        return timestamp;
    }
}


public class _359_LoggerRateLimiter {
    
    
    /** Initialize your data structure here. */
    
    Queue<Node> que;
    HashSet<String> printed;
    Node rear;
    public _359_LoggerRateLimiter() {
        que = new LinkedList<Node>();
        rear = null;
        printed = new HashSet<String>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        checkTime(timestamp);
        
        if (printed.contains(message)) return false;

        if (rear != null && rear.sameTime(timestamp)) rear.addMessage(message);
        else {
            Node node = new Node(timestamp);
            node.addMessage(message);
            que.offer(node);
            rear = node;
        }
        printed.add(message);
        return true;

        
    }
    
    public void checkTime(int timestamp) {
        
        while (!que.isEmpty() && timestamp - que.peek().time() >= 10) {
            Node head = que.poll();
            for (String str: head.getMessages()) {
                if (printed.contains(str)) printed.remove(str);
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
