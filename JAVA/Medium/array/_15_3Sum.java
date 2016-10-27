package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, 
 * are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *      [-1, 0, 1],
 *      [-1, -1, 2]
 * ]
 *
 */

public class _15_3Sum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return res;
        Arrays.sort(nums);
        
        for (int one = 0; one < len - 2; one++) {
            if (one != 0 && nums[one] == nums[one - 1]) continue;
            
            int two = one + 1;
            int three = len - 1;
            
            while (two < three) {
                int sum = nums[one] + nums[two] + nums[three];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[one]);
                    list.add(nums[two]);
                    list.add(nums[three]);
                    res.add(list);
                    two++;
                    three--;
                    while (two < three && nums[two] == nums[two - 1]) two++;
                    while (three > two && nums[three] == nums[three + 1]) three--;
                    
                }
                else if (sum > 0) three--;
                else two++;
            }
        }
        
        return res;
        
    }

}
