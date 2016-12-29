package array;

public class _33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) return -1;
        if (nums[0] < nums[nums.length - 1]) return bs(nums, 0, nums.length - 1, target);
        
        int left = 0;
        int right = nums.length - 1;
        
        if (left == right && nums[left] == target) return left;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= nums[0]) left = mid + 1;
            else right = mid;
        }
        
        if (target >= nums[0]) return bs(nums, 0, left - 1, target);
        return bs(nums, left, nums.length - 1, target);
        
    }
    
    private int bs(int[] nums, int lo, int hi, int k) {
        if (lo > hi) return -1;
        if (k < nums[lo] || k > nums[hi]) return -1;
        
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] == k) return mid;
            if (nums[mid] < k) lo = mid + 1;
            else hi = mid - 1;
        }
        
        return -1;
        
    }
}
