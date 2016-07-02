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
    	
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	for(int idx = 0; idx < nums.length; idx ++){
    		int complement = target - nums[idx];
    		if(map.containsKey(complement) && map.get(complement) != idx){
    			return new int[]{map.get(complement), idx};
    		}
    		map.put(nums[idx], idx);
    	}
    	
        return null;
    }

}
