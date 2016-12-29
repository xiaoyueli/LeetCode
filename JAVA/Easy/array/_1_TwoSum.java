package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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
    
    // with duplicates
    public List<int[]> solve(int[] nums, int target) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<int[]> pairs = new ArrayList<int[]>();
        
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (!map.containsKey(val)) {
                if (map.containsKey(target - val)) pairs.add(new int[]{val, target - val});
                map.put(val, new ArrayList<Integer>());   
            }
            map.get(val).add(i);
        }
        
        List<int[]> res = new ArrayList<>();
        
        for (int[] pair: pairs) {
            for (int i: map.get(pair[0])) {
                for (int j: map.get(pair[1])) {
                    res.add(new int[]{i, j});
                }
            }
        }
        
        return res;
        
    }
    
    public static void main(String[] args) {
        
        _1_TwoSum test = new _1_TwoSum();
        
        int[] nums = new int[] {1,3,4,2,5,3,2,6,8,6,9};
        List<int[]> res = test.solve(nums, 10);
        
        for (int[] pair: res) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }

}
