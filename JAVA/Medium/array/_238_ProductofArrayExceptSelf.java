package array;

/**
 * Given an array of n integers where n > 1, nums, return an array output 
 * such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up:
 * Could you solve it with constant space complexity? 
 * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 *  第一次遍历存储当前值左边值得积
 *  第二次遍历乘上当前值右边值得积
 *
 */

public class _238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int[] output = new int[nums.length];
        int proPre = 1; 
        output[0] = 1;
        for (int idx = 1; idx < nums.length; idx++) {
            proPre *= nums[idx - 1];
            output[idx] = proPre;  
        }
        
        int proAfter = 1;
        for (int idx = nums.length - 2; idx >= 0; idx--) {
            proAfter *= nums[idx + 1];
            output[idx] *= proAfter;
        }
        
        return output;
    }
}