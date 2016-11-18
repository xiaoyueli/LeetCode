package sort;

/**
 * 
 * @author xiaoyue
 * 
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]...
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 *  
 *  思路：
 *  从0开始，在偶数位时，判断与下一位的关系需要小于，大于就交换
 *  在奇数位时，能保证比前面的大，所以只需判断与下一位的关系，小于就交换
 *  
 *  方法二，先sort，然后从第二位开始，每两位交换一下
 */

public class _280_WiggleSort {
    
    public void wiggleSort(int[] nums) {
        
        int len = nums.length;
        boolean flag = true;  // 用来标记交替
        
        for (int idx = 0; idx + 1 < len; idx ++) {
            if (flag && nums[idx] > nums[idx + 1])
                swap(nums, idx, idx + 1);
            else if (!flag && nums[idx] < nums[idx + 1])
                swap(nums, idx, idx + 1);
                
            flag = !flag;
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
