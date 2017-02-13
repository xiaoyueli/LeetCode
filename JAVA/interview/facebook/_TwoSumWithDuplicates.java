package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * Example:
    Given nums = [2, 7, 11, 15], target = 9,
    
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
 * 
 * with duplicate number, 返回所有的可能的index pairs，
 */

public class _TwoSumWithDuplicates {
    
    public List<int[]> solve(int[] nums, int k) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        List<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k - nums[i])) {
                for (int j: map.get(k - nums[i])) {
                    res.add(new int[]{j, i});
                }
            }
            if (!map.containsKey(nums[i])) map.put(nums[i], new HashSet<Integer>());
            map.get(nums[i]).add(i);
        }
        
        for (int[] pair: res) System.out.println(pair[0] + " " + pair[1]);
        
        return res;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _TwoSumWithDuplicates test = new _TwoSumWithDuplicates();
        int[] nums = new int[]{1, 4, 2, 7 ,5, 4, 7, 6 ,2, 9};
        test.solve(nums, 9);
    }

}
