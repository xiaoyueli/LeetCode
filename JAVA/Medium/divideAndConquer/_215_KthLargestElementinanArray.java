package divideAndConquer;

/**
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * 最小堆，控制堆的数量为k
 */

import java.util.PriorityQueue;

public class _215_KthLargestElementinanArray {
    
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        int len = nums.length;
        for (int idx = 0; idx < len; idx++) {
            int value = nums[idx];
            if (minHeap.size() < k) minHeap.offer(value);
            else if (value > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(value);
            }
        }
        
        return minHeap.peek();
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
