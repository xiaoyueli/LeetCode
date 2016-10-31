package array;

public class _283_MoveZeroes {
    
    public void moveZeroes(int[] nums) {
        
        int zero = 0;
        int len = nums.length;
        
        for (int idx = 0; idx < len; idx++) {
            int val = nums[idx];
            if (val != 0) {
                swap(nums, zero, idx);
                zero++;
            }
        }
        
    }
    
    private void swap(int[] seq, int i, int j) {
        int temp = seq[i];
        seq[i] = seq[j];
        seq[j] = temp;
    }
}
