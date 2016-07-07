package array;

public class _80_RemoveDuplicatesfromSortedArray2 {
    
    public int removeDuplicates(int[] nums) {
        
        int len = 1;
        int cnt = 1;
        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx] != nums[idx - 1]) {
                nums[len++] = nums[idx];
                cnt = 1;
            }
            else if (cnt < 2) {
                nums[len++] = nums[idx];
                cnt++;
            }
        }
        return len;
        
    }
}
