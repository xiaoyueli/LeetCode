package reservoirSampling;

import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
 * 
 * Example:
 * 
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * 
 * // Shuffle the array [1,2,3] and return its result. 
 * Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * 
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * 
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 单纯的用random函数 + swap
 * 
 *
 */
public class _384_ShuffleanArray {
	
    int[] nums;

    public _384_ShuffleanArray(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        int len = nums.length;
        int[] res = new int[len];
        for (int idx = 0; idx < len; idx++) res[idx] = nums[idx];
        Random rand = new Random();
        
        
        for (int idx = len - 1; idx > 0; idx--) {
            int pos = rand.nextInt(idx + 1);
            int val = res[idx];
            res[idx] = res[pos];
            res[pos] = val;
        }
        return res;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
