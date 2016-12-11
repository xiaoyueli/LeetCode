package design;

import java.util.HashMap;

/**
 * 
 * @author xiaoyue
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 * 题意：
 * set和get的时候均需要更新被访问的key值到队尾
 * 如果存储的value超过了capacity，需要删掉最不常被访问的数据，也就是队首元素
 */

public class _146_LRUCache {
    
    HashMap<Integer, DNode> map;
    MyList ls;
    int limit;
    
    public _146_LRUCache(int capacity) {
        map = new HashMap<Integer, DNode>();
        ls = new MyList();
        limit = capacity;
    }
    
    class DNode {
        int key;
        int val;
        DNode pre;
        DNode next;
        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    class MyList {
        
        DNode head;
        DNode rear;
        int size;
        
        public MyList() {
            head = new DNode(0, 0);
            rear = head;
            size = 0;
        }
        
        public void add(DNode dn) {
            rear.next = dn;
            dn.pre = rear;
            rear = dn;
            size++;

        }
        
        public void remove(DNode dn) {

            dn.pre.next = dn.next;
            if (dn.next != null) dn.next.pre = dn.pre;
            else rear = dn.pre;
            dn.next = null;
            dn.pre = null;
            size--;
        }
        
        public DNode deleteFront() {
           
            DNode temp = head.next;
            head.next = temp.next;
            temp.next.pre = head;
            temp.next = null;
            temp.pre = null;
            size--;
            return temp;
        }
        
        public int size() {
            return size;
        }
        
        
    }
    

    
    public int get(int key) {
        
        if (map.containsKey(key)) {
            DNode dn = map.get(key);
            ls.remove(dn);
            ls.add(dn);
            return dn.val;
        }
        return -1;

    }
    
    public void set(int key, int value) {
        
        if (map.containsKey(key)) {
            DNode dn = map.get(key);
            ls.remove(dn);
        }
        
        DNode dn = new DNode(key, value);
        ls.add(dn);
        map.put(key, dn);
        
        if (ls.size() > limit) {
            DNode node = ls.deleteFront();
            map.remove(node.key);
        }
        
        
    }

}
