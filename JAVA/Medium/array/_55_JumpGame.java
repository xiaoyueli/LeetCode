package array;

/**
 * Given an array of non-negative integers, 
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * 计算当前值所能到达的最远距离，更新最远距离
 * 如果当前值所在位子已经超过能到达的位置则退出
 * 否则计算新的最远距离
 *
 */

public class _55_JumpGame {
    
    public boolean canJump(int[] nums) {
        
        int maxDis = nums[0];
        
        for (int pos = 1; pos < nums.length && pos <= maxDis; pos++) {
 
            int dis = nums[pos] + pos;  // 当前值所能到达的最远距离
            if (dis > maxDis) maxDis = dis;
        }
        
        if (maxDis >= nums.length - 1) return true;
        return false;
        
    }
    
}
