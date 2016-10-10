package dynamicProgramming;

import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, 
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * 
 * Note:
 * Both the array size and each of the array element will not exceed 100.
 * 
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 * @author xiaoyue
 * 思路，组合问题
 *
 */

public class _416_PartitionEqualSubsetSum {
	
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for (int i: nums) sum += i;
        if (sum % 2 != 0) return false;
        sum /= 2;
        
        return helper(nums, 0, 0, sum);
    }
    
    private boolean helper(int[] nums, int curIdx, int curSum, int sum) {
        if (curSum == sum) return true;
        if (curSum > sum) return false;
        if (curIdx == nums.length) return false;
        
        curSum += nums[curIdx];
        boolean val = helper(nums, curIdx + 1, curSum, sum);
        if (val) return true;
        curSum -= nums[curIdx];
        return helper(nums, curIdx + 1, curSum, sum);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_416_PartitionEqualSubsetSum test = new _416_PartitionEqualSubsetSum();
		int[] nums = new int[] {80,38,97,19,81,96,70,35,12,44,33,51,78,86,31,74,94,54,11,91,7,90,83,12,91,67,40,80,39,87,17,49,66,56,15,99,95,91,22,49,14,23,18,74,22,62,14,94,75,97,45,32,9,21,14,70,93,14,91,6,99,12,29,32,26,33,44,24,82,84,95,10,91,38,23,27,64,88,83,85,7,23,62,49,60,67,31,55,87,42,61,4,7,10,12,8,94,9,30,59};
		Arrays.sort(nums);
//		test.canPartition(nums);
		

	}

}

  
  
