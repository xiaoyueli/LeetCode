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

        int len = nums.length;
        int idx = 0;
             
        while (idx < len) {
            
            if (nums[idx] > 0 && nums[idx] != idx + 1 && nums[idx] <= len && nums[idx] != nums[nums[idx] - 1]) {
                swap(nums, idx, nums[idx] - 1);
            }
            else idx++;
        }
        
        idx = 0;
        while (idx < len && nums[idx] == idx + 1) idx++;
        
        return idx + 1;
        
    }
    
    private void swap(int[] seq, int i, int j) {
        int temp = seq[i];
        seq[i] = seq[j];
        seq[j] = temp;
    }

}
