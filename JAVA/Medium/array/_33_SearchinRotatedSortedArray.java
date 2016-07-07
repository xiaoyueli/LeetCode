package array;

public class _33_SearchinRotatedSortedArray {
    int tar;
    int[] nums;
    
    public int search(int[] nums, int target) {
        this.tar = target;
        this.nums = nums;
        if (nums.length == 0) return -1;
        int res = find(0, nums.length - 1);
        
        return res;
    }
    
    public int find(int left, int right) {
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == tar) return mid;
            if (nums[mid] >= nums[left]) {
                
                if (tar < nums[mid] && tar >= nums[left])
                    return binarySearch(left, mid - 1);
                left = mid + 1;
            }
            else {
                if (tar > nums[mid] && tar <= nums[right]) return binarySearch(mid + 1, right);
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == tar) return mid;
            if (nums[mid] < tar)  left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
