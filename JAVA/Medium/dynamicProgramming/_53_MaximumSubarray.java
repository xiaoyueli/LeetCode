package dynamicProgramming;

/**
 * Find the contiguous subarray within an array 
 * (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * More practice:
 * If you have figured out the O(n) solution, 
 * try coding another solution using the divide and conquer approach, 
 * which is more subtle.
 * 
 */

public class _53_MaximumSubarray {


    public int maxSubArray(int[] nums) {
        
        int res = Integer.MIN_VALUE;
        int sum = 0;
        
        int len = nums.length;
        for (int idx = 0; idx < len; idx++) {
            
            sum += nums[idx];
            if (sum > res) res = sum;
            if (sum < 0) sum = 0;
        }
        
        return res;
        
    }
    public static void main(String[] args) {
        _53_MaximumSubarray test = new _53_MaximumSubarray();
        test.maxSubArray(new int[] {31,-41,59,26,-53,58,97,-93,-23,84});
    }
}
