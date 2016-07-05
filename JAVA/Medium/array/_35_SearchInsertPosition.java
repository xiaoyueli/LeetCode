package array;

public class _35_SearchInsertPosition {
    
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid >= nums.length) break;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return left;
    }
}