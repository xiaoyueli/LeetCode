package array;

import java.util.HashSet;


public class _217_ContainsDuplicate {
    
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int idx = 0; idx < nums.length; idx++) {
            if (set.contains(nums[idx])) return true;
            else set.add(nums[idx]);
        }
        return false;
    }


}
