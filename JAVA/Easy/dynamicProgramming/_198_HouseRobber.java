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
        
        int len = nums.length;
        if (len == 0) return 0;
        
        int rob = nums[0];
        int noRob = 0;
        
        for (int idx = 1; idx < len; idx++) {
            int val = nums[idx];
            
            int temp = rob;
            rob = noRob + val;
            noRob = Math.max(temp, noRob);
        }
        
        return Math.max(rob, noRob);
        
    }

}
