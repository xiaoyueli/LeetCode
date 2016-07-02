package array;

public class _26_RemoveDuplicatesfromSortedArray {
    
    public int removeDuplicates(int[] nums) {
        int length = 0;
        int last = Integer.MAX_VALUE;
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] != last) {
                nums[length++] = nums[idx];
                last = nums[idx];
            }
        }
        return length;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
