package array;

public class _34_SearchforaRange {
    
    public int[] searchRange(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid >= nums.length) break;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else {
                boolean flag = true;
                left = subSearch(left, mid, nums, target, flag);
                right = subSearch(mid, right, nums, target, !flag);
                return new int[]{left, right};
            }
        }
        
        return new int[]{-1, -1};

    }
    
    public int subSearch(int left, int right, int[] nums, int tar, boolean flag) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid >= nums.length) break;
            if (flag) {
                if (nums[mid] == tar) right = mid -1;
                else left = mid + 1;
            }
            else {
                if (nums[mid] == tar) left = mid + 1;
                else right = mid - 1; 
            }
        }
        
        if(flag) return right + 1;
        else return left - 1;
    }
}
