package hashtable;

import java.util.Arrays;

/**
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * 
 *  A 异或 A = 0；
 *  a 和 B 进行异或运算后，再和A异或，得B
 *
 */

public class _136_SingleNumber {
    
    public int singleNumber(int[] nums) {
        
        int single = 0;
        for (int i: nums) single ^= i;
        
        return single;
    }
    
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        
        int len = nums.length;
        
        if (len == 1) return nums[0];
        for (int idx = 0; idx < len - 1; idx += 2) {
            if (nums[idx] == nums[idx + 1]) continue;
            return nums[idx];    
        }
        
        return nums[len - 1];
    }
}
