package array;

/**
 * Given an array with n objects colored red, 
 * white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, 
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 */

public class _75_SortColors {
    
    public void sortColors(int[] nums) {
        
        if (nums.length <= 1) return;
        int left = 0;
        int right = nums.length - 1;
        int head = 0;
        
        while (head <= right) {
            if (nums[head] < 1) {
                swap(nums, head, left);
                head++;
                left++;
            }
            else if (nums[head] > 1) {
                swap(nums, head, right);
                right--;
            }
            else if (nums[head] == 1) head++;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
