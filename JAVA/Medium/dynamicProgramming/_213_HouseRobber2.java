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
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
               
        int frob = nums[0];
        int fnoRob = nums[0];
        int nfrob = nums[1];
        int nfnoRob = 0;
        
        for (int idx = 2; idx < len; idx++) {
            int val = nums[idx];
            
            int temp = frob;
            frob = fnoRob + val;
            fnoRob = Math.max(temp, fnoRob);
            
            temp = nfrob;
            nfrob = nfnoRob + val;
            nfnoRob = Math.max(nfnoRob, temp);
        }
        
        int temp = Math.max(nfrob, nfnoRob);
        
        return Math.max(fnoRob, temp);
        
    }

}
