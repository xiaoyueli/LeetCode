package array;

import java.util.HashMap;


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class _1_TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        
        int len = nums.length;
        for (int idx = 0; idx < len; idx++) {
            int other = target - nums[idx];
            if (table.containsKey(other)) return new int[]{table.get(other), idx};
            table.put(nums[idx], idx);
        }
        
        return null;
        
    }

}
