package dynamicProgramming;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * 思路:
 * keep the status of the last day : robbed or not;
 * update the new status based on the status of the last day;
 *
 */

public class _198_HouseRobber {
	
    public int rob(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;
        
        int preRobbed = nums[0];
        int preNotRobbed = 0;
        
        int len = nums.length;
        for (int house = 1; house < len; house++) {
            int money = nums[house];
            
            int currentRob = preNotRobbed + money;
            int currentNotRob = Math.max(preRobbed, preNotRobbed);
            
            preRobbed = currentRob;
            preNotRobbed = currentNotRob;
            
        }
        
        return Math.max(preRobbed, preNotRobbed);
        
    }

}
