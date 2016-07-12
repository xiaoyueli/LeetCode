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
    
    int[] nums;
    public List<List<Integer>> threeSum(int[] nums) {
        
        this.nums = nums;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        boolean flag = false;
        for (int one = 0; one < len; one++) {
            
            int two = one + 1;
            int three = len - 1;
            
            if (flag && nums[one] == nums[one - 1]) continue;
            else flag = false;
            
            while (two < three) {
                int val = nums[one] + nums[two] + nums[three];
                if (val == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[one]);
                    list.add(nums[two]);
                    list.add(nums[three]);
                    res.add(list);
                    flag = true;
                    while (two < len - 1 && nums[two] == nums[++two]);
                    while (three > two && nums[three] == nums[--three]);
                }
                else if (val < 0) two++;
                else three--;
            }
        }
        
        return res;
    }

}
