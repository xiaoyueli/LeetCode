package design;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author xiaoyue
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

    Examples: 
    [2,3,4] , the median is 3
    
    [2,3], the median is (2 + 3) / 2 = 2.5
    
    Design a data structure that supports the following two operations:
    
    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.
    For example:
    
    add(1)
    add(2)
    findMedian() -> 1.5
    add(3) 
    findMedian() -> 2
 * 思路：
 * 大小两个PriorityQueue
 * 
 */

public class _295_FindMedianfromDataStream {

    // Adds a number into the data structure.
    
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;
    public _295_FindMedianfromDataStream() {
        small = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        big = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        big.offer(small.poll());
        if (small.size() < big.size()) small.offer(big.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        
        if (small.size() == big.size()) return (small.peek()  + big.peek()) * 1.0 / 2;
        return small.peek() * 1.0;
        
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
