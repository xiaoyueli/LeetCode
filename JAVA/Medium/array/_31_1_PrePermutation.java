package array;

public class _31_1_PrePermutation {
    
    public void solve(int[] nums) {
        
        
        int pivot = -1;
        for (int i = nums.length - 1; i - 1 >= 0; i--) {
            if (nums[i] > nums[i - 1]) continue;
            pivot  = i - 1;
            break;
        }
        
        if (pivot == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, pivot);
                reverse(nums, pivot + 1, nums.length - 1);
                return;
            }
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
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
        _31_1_PrePermutation test = new _31_1_PrePermutation();
        
        int[] nums = new int[] {2,1};
        test.solve(nums);
        
        for (int i : nums) {
            System.out.print(i + " ");
        }
        

    }

}
