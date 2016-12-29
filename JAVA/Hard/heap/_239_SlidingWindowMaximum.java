package heap;

import java.util.LinkedList;

/**
 * 
 * @author xiaoyue
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

    For example,
    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
    
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
    Therefore, return the max sliding window as [3,3,5,5,6,7].
    
    Note: 
    You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
    
    Follow up:
    Could you solve it in linear time?
    
    Hint:
    
    How about using a data structure such as deque (double-ended queue)?
    The queue size need not be the same as the window’s size.
    Remove redundant elements and the queue should store only elements that need to be considered.
 *
 * 思路，用一个LinkedList存窗口size内的数
 * LinkedList的头元素是当前窗口内的最大值
 * 如果加入的元素比当前最大值大，抛弃掉之前的所有元素，将新加的元素加入list
 * 否则将新元素加入list尾部
 * 
 * 如果list的大小超过K，删掉最前一个元素，更新list为头元素为当前最大值
 */

public class _239_SlidingWindowMaximum {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums == null || nums.length == 0) return nums;
        
        LinkedList<Integer> ls = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        
        int max = Integer.MIN_VALUE;
        int idx = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (ls.size() == k) {
                ls.removeFirst();
                if (ls.isEmpty()) max = Integer.MIN_VALUE;
                else max = update(ls);
            }
            if (nums[i] > max) {
                max = nums[i];
                ls = new LinkedList<Integer>();
                ls.add(max);
            }
            else ls.add(nums[i]);
            if (i >= k - 1) res[idx++] = max;
        }
        
        return res;
    }
    
    private int update(LinkedList<Integer> ls) {
        int max = ls.get(0);
        int i = 1;
        while (i < ls.size()) {
            if (ls.get(i) > max) {
                max = ls.get(i);
                while (ls.get(0) != max) ls.removeFirst();
                i = 0;
            }
            i++;
        }
        return max;
    }
    
    
    // 自定义类
    public int[] maxSlidingWindow1(int[] nums, int k) {
        
        int[] res = new int[nums.length - k + 1];
        if (nums == null || nums.length == 0) return nums;
        MyList ls = new MyList(k);
        
        int idx = 0;
        while (idx < k) ls.add(nums[idx++]);
        
        idx = 0;
        res[idx++] = ls.max();
        
        for (int i = k; i < nums.length; i++) {
            ls.add(nums[i]);
            res[idx++] = ls.max();
        }
        
        return res;    
    }

}

class DNode {
    
    int val;
    DNode next;
    
    public DNode(int val) {
        this.val = val;
    }
}

class MyList {
    
    DNode head;
    DNode tail;
    int size;
    int capacity;
    int max;
    
    public MyList(int limit) {
        head = new DNode(0);
        tail = head;
        size = 0;
        capacity = limit;
        max = Integer.MIN_VALUE;
    }
    
    public void add(int val) {
        if (val > max) {
            max = val;
            head.next = new DNode(val);
            tail = head.next;
            size = 1;
        }
        else {
            tail.next = new DNode(val);
            tail = tail.next;
            size++;
        }
        
        if (size > capacity) {
            head.next = head.next.next;
            size--;
            max = findMax(head.next);
        }

    }
    
    public int findMax(DNode node) {
        
        int max = Integer.MIN_VALUE;
        size = 0;
        while (node != null) {
            size++;
            if (node.val >= max) {
                max = node.val;
                head.next = node;
                size = 1;
            } 
            node = node.next;
            
        }
        
        return max;
    }
    
    public int max() {
        return max;
    }
}
