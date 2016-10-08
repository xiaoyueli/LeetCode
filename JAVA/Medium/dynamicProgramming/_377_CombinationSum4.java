package dynamicProgramming;

/**
 * Given an integer array with all positive numbers and no duplicates, 
 * find the number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3]
 * target = 4
 * 
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 * 
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 * 
 * @author xiaoyue
 *
 */

public class _377_CombinationSum4 {
	
	
    public int combinationSum4(int[] nums, int target) {
        
        int[] counts = new int[target + 1]; // 每一个element对应记录从1到target，candidate number能sum up to的数目
        counts[0] = 1;
        
        for (int subTar = 1; subTar <= target; subTar++) {
            for (int num : nums) {
                if (subTar >= num) {
                	// 当前sub target 能由当前num + 组成(subtar - num)的组合构成
                    counts[subTar] += counts[subTar - num];
                }
            }
        }
        
        return counts[target];
    }
	
	
	
	
    // bc 超时
//    int res;
//    public int combinationSum4(int[] nums, int target) {
//        
//        res = 0;
//        sumHelper(nums, 0, target);
//        return res;
//    }
//    
//    private void sumHelper(int[] nums, int cur, int target) {
//        if (cur == target) {
//            res++;
//            return;
//        }
//        if (cur > target) return;
//        
//        int len = nums.length;
//        for (int idx = 0; idx < len; idx++) {
//            cur += nums[idx];
//            sumHelper(nums, cur, target);
//            cur -= nums[idx];
//        }
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_377_CombinationSum4 test = new _377_CombinationSum4();
		test.combinationSum4(new int[]{1, 2, 3}, 4 );

	}

}
