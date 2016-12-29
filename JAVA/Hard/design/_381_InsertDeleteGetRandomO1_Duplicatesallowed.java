package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author xiaoyue
 * 
 * Design a data structure that supports all following operations in average O(1) time.

    Note: Duplicate elements are allowed.
    insert(val): Inserts an item val to the collection.
    remove(val): Removes an item val from the collection if present.
    getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
    Example:
    
    // Init an empty collection.
    RandomizedCollection collection = new RandomizedCollection();
    
    // Inserts 1 to the collection. Returns true as the collection did not contain 1.
    collection.insert(1);
    
    // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
    collection.insert(1);
    
    // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
    collection.insert(2);
    
    // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
    collection.getRandom();
    
    // Removes 1 from the collection, returns true. Collection now contains [1,2].
    collection.remove(1);
    
    // getRandom should return 1 and 2 both equally likely.
    collection.getRandom();
 * 
 * 思路：
 * 用两个hashMap: 一个存val orderSet, 一个存order val
 */

public class _381_InsertDeleteGetRandomO1_Duplicatesallowed {

    /** Initialize your data structure here. */
    
    HashMap<Integer, Integer> orders;
    HashMap<Integer, List<Integer>> vals;
    int size;
    public _381_InsertDeleteGetRandomO1_Duplicatesallowed() {
        orders = new HashMap<Integer, Integer>();
        vals = new HashMap<Integer, List<Integer>>();
        size = 0;
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (vals.containsKey(val)) {
            vals.get(val).add(size);
            orders.put(size++, val);
            return false;
        }
        
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(size);
        vals.put(val, ls);
        orders.put(size++, val);
        return true;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!vals.containsKey(val)) return false;
        size--;
        
        List<Integer> ls = vals.get(val);
        int order = ls.get(0);
        ls.remove((Integer)order);
        if (ls.isEmpty()) vals.remove(val);

        if (order != size) {
            int last = orders.get(size);
            List<Integer> lls = vals.get(last);
            lls.remove((Integer)size);
            lls.add(order);
            orders.put(order, last);
        }
        orders.remove(size);
        return true;
        
    }
    
    
    // 1 1 2 
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random rand = new Random();
        int order = rand.nextInt(size);
        return orders.get(order);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
