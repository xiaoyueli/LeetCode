package array;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 */

import java.util.Arrays;

public class _268_MissingNumber {
    
    public int missingNumber(int[] nums) {
        
        int len = nums.length;
        int sum = (1 + len) * len / 2;
        
        int sub = 0;
        for (int num: nums) sub += num;
        
        return sum - sub;
        
    }
    
    public int missingNumber2(int[] nums) {
        
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int missing = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
                missing = left;
            }
            else {
                missing = mid;
                right = mid - 1;
            }
        }
        
        return missing;
    }
}
