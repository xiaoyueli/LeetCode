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
        move(nums, right, nums.length - 1, 1, 1);
        
        if (nums[left] != 0) left--;
        move(nums, left, 0, 0, -1);
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void move(int[] nums, int sta, int end, int val, int step) {
        
        int idx = sta;
        for (int i = sta; i != end + step; i += step) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx += step;
            }
        }
        
        for (; idx != end + step; idx += step) nums[idx] = val;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _Move0and1 test = new _Move0and1();
        int[] nums = new int[]{4,1,0,3,1,5,2,1,0,0,1,2,6,0,9};
        
        test.solve(nums);
        
        for (int i: nums) System.out.print(i + " ");

    }

}
