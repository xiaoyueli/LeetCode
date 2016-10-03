package dynamicProgramming;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example:
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * 
 * @author xiaoyue
 *
 */

public class _303_RangeSumQueryImmutable {
	
    int[] cache;
    public _303_RangeSumQueryImmutable(int[] nums) {
        
        int len = nums.length;
        if (len != 0) {
            
            cache = new int[len];
            cache[0] = nums[0];
            for (int idx = 1; idx < len; idx++) {
                cache[idx] = cache[idx - 1] + nums[idx];
            }
        }
 
        
    }

    public int sumRange(int i, int j) {
        
        if (i == 0) return cache[j];
        return cache[j] - cache[i - 1];
    }
}

//Your NumArray object will be instantiated and called as such:
//NumArray numArray = new NumArray(nums);
//numArray.sumRange(0, 1);
//numArray.sumRange(1, 2);
