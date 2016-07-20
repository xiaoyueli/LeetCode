package sort;

import java.util.Arrays;

/**
 * Given an unsorted array nums, 
 * reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * 
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * 排序后倒序穿插前后半段数组
 *
 */

public class _324_WiggleSort2 {
    int [] nums;
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;

        Arrays.sort(nums);
        int[] other = nums.clone();
        int mid = (len - 1) / 2;
        boolean flag = true;
        int small = mid;
        int large = len - 1;
        for (int idx = 0; idx < len; idx++) {
            if (flag) nums[idx] = other[small--];
            else nums[idx] = other[large--];
            flag = !flag;
        }     
    }
}
