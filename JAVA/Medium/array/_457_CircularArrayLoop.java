package array;

import java.util.HashSet;

/**
 * 
 * @author xiaoyue
 * You are given an array of positive and negative integers. 
 * If a number n at an index is positive, then move forward n steps. 
 * Conversely, if it's negative (-n), move backward n steps. 
 * Assume the first element of the array is forward next to the last element, and the last element is backward next to the first element. 
 * Determine if there is a loop in this array. 
 * A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be "forward" or "backward'.
 * 
 * Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.
 * Example 2: Given the array [-1, 2], there is no loop.
 * Note: The given array is guaranteed to contain no element "0".
 * Can you do it in O(n) time complexity and O(1) space complexity?
 *
 *  题意，查看数组内有没有同一个方向的圈。
 *  用快慢指针。快慢指针相遇时，慢指针走过的点不在圈上，设置其值为0；
 *  注意判断是否是同一个方向移动
 */

public class _457_CircularArrayLoop {
    
    // two pointer;
    public boolean circularArrayLoop(int[] nums) {
        
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            
            if (nums[i] == 0) continue;
            
            boolean isForward = true;
            if (nums[i] < 0) isForward = false;
            int slow = i, fast = i;
            int cnt = 0;
            do {
                int temp = slow;
                
                slow = (slow + nums[slow]) % len;
                if (slow < 0) slow += len;
                
                if (isForward && nums[fast] < 0 || !isForward && nums[fast] > 0) break;
                fast = (fast + nums[fast]) % len;
                if (fast < 0) fast += len;
                
                if (isForward && nums[fast] < 0 || !isForward && nums[fast] > 0) break;
                fast = (fast + nums[fast]) % len;
                if (fast < 0) fast += len;
                
                cnt++;
                nums[temp] = 0;
            }while (slow != fast);
            
            if (slow == fast && cnt > 1) return true;
            
        }
        
        return false;
    }
    
    
    // dfs
    public boolean circularArrayLoop2(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                boolean isForward = nums[i] > 0;
                if (dfs(nums, i, i, isForward, 0) > 1) return true;
            }
        }
        
        return false;
    }
    
    private int dfs(int[] nums, int cur, int last, boolean isForward, int cnt) {
        
        if (isForward && nums[cur] < 0 || !isForward && nums[cur] > 0) return 0;
        if (nums[cur] == 0 && last != cur) return cnt;
        else if (nums[cur] == 0) return 0;
        int next = (cur + nums[cur]) % nums.length;
        if (next < 0) next += nums.length;
        nums[cur] = 0;
        return dfs(nums, next, cur, isForward, cnt + 1);
    }


}
