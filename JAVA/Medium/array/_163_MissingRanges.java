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
        if (nums.length == 0) {
            add(res, lower, upper);
            return res;
        }
        
        if (nums[0] > lower) {
            add(res, lower, nums[0] - 1);
            lower = nums[0];
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] - 1 == nums[i - 1]) lower = nums[i];
            else {
                add(res, lower + 1, nums[i] - 1);
                lower = nums[i];
            }
        }
        
        if (lower != upper) add(res, lower + 1, upper);
        
        return res;
        
    }
    
    private void add(List<String> res, int sta, int end) {
        if (sta > end) return;
        if (sta == end) res.add(sta + "");
        else res.add(sta + "->" + end);
    }

}
