package array;

/**
 * 
 * @author xiaoyue
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 
 * 思路;
 * k 对 len 取模 就是需要移动的步数 i； 然后将后i个数移到前面
 * 技巧：
 * 将前len - i 个数反转， 然后对整个数组反转，然后再对前i个数反转
 * 
 * 4 3 2 1 5 6 7 --> 7 6 5 1 2 3 4 --> 5 6 7 1 2 3 4
 *
 */

public class _189_RotateArray {
    
    
    // in place
    public void rotate(int[] nums, int k) {
        
        int len = nums.length;
        
        k = k % len;
        
        reverse(nums, 0, len - k - 1);
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        
    }
    
    private void reverse(int[] nums, int sta, int end) {
        
        while (sta < end) {
            swap(nums, sta++, end--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    // extra space
    public void rotate2(int[] nums, int k) {
        
        int len = nums.length;
        
        int[] temp = new int[len];
        for (int idx = 0; idx < len; idx++) {
            temp[idx] = nums[idx];
        }
        
        k = k % len;
        
        int i = 0;
        for (int idx = len - k; idx < len; idx++) {
            nums[i++] = temp[idx];
        }
        
        for (int idx = 0; idx < len - k; idx++) {
            nums[i++] = temp[idx];
        }
        
        
    }  
}
