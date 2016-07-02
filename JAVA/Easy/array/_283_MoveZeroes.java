package array;

public class _283_MoveZeroes {
    
    public void moveZeroes(int[] nums) {
        int non0 = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] != 0) {
                swap(non0, idx, nums);
                non0++;
            }
        }
    }
    
    public void swap(int here, int other, int[] arr) {
        if (here == other) return;
        int temp = arr[here];
        arr[here] = arr[other];
        arr[other] = temp;
    }
}
