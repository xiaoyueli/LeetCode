package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [
  	[1,2,3],
  	[1,3,2],
  	[2,1,3],
  	[2,3,1],
  	[3,1,2],
  	[3,2,1]
	]
 * @author xiaoyue
 *
 */

public class _46_Permutations {
	
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        
        res = new ArrayList<>();
        int[] cache = new int[nums.length];
        
        helper(cache, nums, 0, nums.length);
        
        return res;
    }
    
    private void helper(int[] cache, int[] nums, int pos, int len) {
        if (pos == len) {
            List<Integer> ans = new ArrayList<Integer>();
            for (int i : cache) {
                ans.add(i);
            }
            res.add(ans);
            return;
        }
        
        for (int idx = 0; idx < len; idx++) {
            if (isValid(nums[idx], pos, cache)) {
                cache[pos] = nums[idx];
                helper(cache, nums, pos + 1, len);
            }
            
        }
    }
    
    private boolean isValid(int val, int len, int[] cache) {
        
        for (int idx = 0; idx < len; idx++) {
            if (cache[idx] == val) return false;
        }
        return true;
    }

}
