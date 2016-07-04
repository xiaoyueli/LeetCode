package array;

import java.util.Arrays;

public class _268_MissingNumber {
    
    public int missingNumber(int[] nums) {
        
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
