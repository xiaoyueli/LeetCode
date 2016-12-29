package facebook;

/**
 * 就是要moveZero到前面，moveOne到后面，不改变顺序
 * @author xiaoyue
 *
 * 思路，two pointer交换0和1
 * 然后再从相遇点分别像两边移动其余数字
 */

public class _Move0and1 {
    
    public void solve(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            while (left < right && nums[left] != 1) left++;
            
            while (left < right && nums[right] != 0) right--;
            
            swap(nums, left++, right--);
        }
        
        if (nums[right] != 1) right++;
        int p = right;
        for (int i = right; i < nums.length; i++) {
            if(nums[i] != 1) swap(nums, p++, i);
        }
        
        if (nums[left] != 0) left--;
        p = left;
        for (int i = left; i >= 0; i--) {
            if (nums[i] != 0) swap(nums, p--, i);
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _Move0and1 test = new _Move0and1();
        int[] nums = new int[]{4,1,0,3,1,5,2,1,0,0,1,2,6,0,9};
        
        test.solve(nums);
        
        for (int i: nums) System.out.print(i + " ");

    }

}
