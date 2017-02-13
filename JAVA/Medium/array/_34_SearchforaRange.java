package array;

/**
 * 
 * @author xiaoyue
 * 
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).
    
    If the target is not found in the array, return [-1, -1].
    
    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].
 * 
 * 思路：
 * 找target和比它大1的值，求范围，注意corner case
 */

public class _34_SearchforaRange {
    
    public int[] searchRange(int[] nums, int target) {
        
        int sta = helper(nums, target);
        if (sta == nums.length || nums[sta] != target) return new int[]{-1, -1};
        int end = helper(nums, target + 1);
        return new int[]{sta, end - 1};
        
    }
    
    private int helper(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        

        return left;
        
    }
}
