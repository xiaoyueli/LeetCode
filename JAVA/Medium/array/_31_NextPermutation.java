package array;

/**
 * 
 * @author xiaoyue
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
    
    The replacement must be in-place, do not allocate extra memory.
    
    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
 * 思路：
 * next permutation:  最后是降序， 找出比最大值小的点，交换它和下一个比它大的数，把那个点之后的序列变为升序
 * pre permutation: 最后是升序，找出比最小值大的点，交换它与上一个比它小的数，把那个点之后变为降序
 */

public class _31_NextPermutation {
    
    public void nextPermutation(int[] nums) {
        
        int len = nums.length;
        
        int pivot = -1;
        for (int idx = len - 1; idx - 1 >= 0; idx--) {

            if (nums[idx - 1] >= nums[idx]) continue;
            pivot = idx - 1;
            break;
        }
        
        if (pivot == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        
        for (int idx = len - 1; idx >= 0; idx--) {
            if (nums[idx] > nums[pivot]) {
                swap(nums, idx, pivot);
                reverse(nums, pivot + 1, len - 1);
                break;
            }
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int left, int right) {
        
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
