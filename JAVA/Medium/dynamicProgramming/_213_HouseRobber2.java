package dynamicProgramming;

/**
 * After robbing those houses on that street, 
 * the thief has found himself a new place for his thievery so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 与house robber 1不同处在于需要分别记录第一个house被抢或没有被抢的情况
 * 最后的最大值取三种状态之一：
 * 1： 第一个房子被抢时，最后一个房子没有被抢
 * 2： 第一个房子没有被抢，最后一个房子被抢
 * 3： 第一个房子没有被抢，最后一个房子也没有被抢
 *
 */

public class _213_HouseRobber2 {
	
    public int rob(int[] nums) {
        
        int len = nums.length;
        if (nums == null || len == 0) return 0;
        if (len == 1) return nums[0];
        
        // ft: first house robbed, current house robbed
        // fnc: first house robbed, current house not robbed
        // nfc: first house not robbed, current house robbed
        // nfnc: first house not robbed, current house not robbed
        int fc = 0;
        int fnc = nums[0];
        int nfc = nums[1];
        int nfnc = 0;
        
        for (int house = 2; house < len; house++) {
            int money = nums[house];
            
            int temp = fnc;
            fnc = Math.max(fc, fnc);
            fc = temp + money;
            
            temp = nfnc;
            nfnc = Math.max(nfc, nfnc);
            nfc = temp + money;
        }
        
        int firstNotRobbed = Math.max(nfc, nfnc);
        return Math.max(fnc, firstNotRobbed);
        
    }

}
