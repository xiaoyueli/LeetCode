package tree;

import java.util.TreeSet;

/**
 * 
 * @author xiaoyue
 * 
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that 
 * the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 */

public class _220_ContainsDuplicate3 {
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        if (k <= 0) return false;
        if (t < 0) return false;
        TreeSet<Long> set = new TreeSet<Long>();
    
        for (int i = 0; i < nums.length; i++) {
            long val = nums[i];
            if (i > k) set.remove((long)nums[i - k - 1]);
            if (!set.subSet(val - t, val + t + 1).isEmpty()) return true;
            set.add(val);
        }
        
        return false;
        
    }

}
