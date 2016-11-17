package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyue
 * 
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 * 
 * 思路：
 * 1，注意数组为空的情况
 * 2，注意差值为1的情况
 * 3，注意前后相等的情况
 *
 */

public class _163_MissingRanges {
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> res = new ArrayList<String>();
        
        int length = nums.length;
        if (length == 0) {
            if (lower == upper) res.add(lower + "");
            else res.add(lower + "->" + upper);
            return res;
        }
        
        if (nums[0] - 1 == lower) res.add(lower + "");
        else if (nums[0] > lower) res.add(lower + "->" + (nums[0] - 1));

        for (int idx = 1; idx < length; idx++) {
            if (nums[idx] - 1 == nums[idx - 1] || nums[idx] == nums[idx - 1]) continue;
            if (nums[idx] - 2 == nums[idx - 1]) res.add((nums[idx] - 1) + "");
            else res.add((nums[idx - 1] + 1) + "->" + (nums[idx] - 1));
        }
        
        if (nums[length - 1] + 1 == upper) res.add(upper + "");
        else if (nums[length - 1] < upper) res.add((nums[length - 1] + 1) + "->" + upper);
            
        
        return res;
    }

}
