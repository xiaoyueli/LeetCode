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
 * 1.Quick select
 * 2. 最小堆，控制堆的数量为k
 * 
 */

import java.util.PriorityQueue;

public class _215_KthLargestElementinanArray {
    
    // quickSort
    public int findKthLargest(int[] nums, int k) {
        
        int len = nums.length;
        return helper(nums, 0, len - 1, len - k + 1);
    }
    
    private int helper(int[] nums, int lo, int hi, int k) {
        
        int pivot = nums[lo];
        int left = lo + 1;
        int right = hi;
        
        while (left <= right) {
            if (nums[left] > pivot) swap(nums, left, right--);
            else left++;
        }

        swap(nums, right, lo);
        if (left == k) return pivot;
        
        if (left > k) return helper(nums, lo, right - 1, k);
        return helper(nums, left, hi, k);
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // minheap
    public int findKthLargest1(int[] nums, int k) {

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
