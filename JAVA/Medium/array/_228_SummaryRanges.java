package array;

/**
 * Given a sorted integer array without duplicates, 
 * return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], 
 * return ["0->2","4->5","7"].
 */

import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges {
    
    public List<String> summaryRanges(int[] nums) {
        
        List<String> list = new ArrayList<String>();
        if (nums.length == 0) return list;
        if (nums.length == 1) {
            list.add(nums[0] + "");
            return list;
        }

        
        int last = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx] - 1 == nums[idx - 1]) {
                if (idx == nums.length - 1) list.add(last + "->" + nums[idx]);
                continue;
            }
            else {
                if (nums[idx - 1] != last) list.add(last + "->" + nums[idx - 1]);
                else list.add(last + "");
                if (idx == nums.length - 1) list.add(nums[idx] + "");
                last = nums[idx];
            }
        }
        
        return list;
        
    }
}