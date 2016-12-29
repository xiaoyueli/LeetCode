package array;

/**
 * 
 * @author xiaoyue
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * 思路：
 * 把元素i放到第i - 1的位置
 * 当i - 1的位置不等于i的时候就交换当前值到i - 1，
 * 其他情况都idx++
 * 
 * 最后再遍历一次数组，第一个i - 1的位置不等于i的数就是missing的
 *
 */

public class _41_FirstMissingPositive {
    
    public int firstMissingPositive(int[] nums) {
        
        if (nums.length == 0) return 1;
        
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length) i++;
            else if (nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) swap(nums, nums[i] - 1, i);
            else i++;
        }
        
        i = 0;
        while (i < nums.length && nums[i] == i + 1) i++;
        
        return i + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
