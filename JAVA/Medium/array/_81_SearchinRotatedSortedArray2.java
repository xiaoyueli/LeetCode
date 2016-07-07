package array;

/**
 * 如果有重复元素，无法通过比较中间值和边界值大小判断目标元素在中间值的左边或是右边
 * 即当中间值和边界值相等时，则用递归搜索中间值两边的子数组
 */

public class _81_SearchinRotatedSortedArray2 {
    int tar;
    int[] nums;
    
    public boolean search(int[] nums, int target) {
        this.tar = target;
        this.nums = nums;
        if (nums.length == 0) return false;
        boolean res = find(0, nums.length - 1);
        
        return res;
    }
    
    public boolean find(int left, int right) {
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == tar) return true;
            if (nums[mid] > nums[left]) {
                
                if (tar < nums[mid] && tar >= nums[left])
                    return binarySearch(left, mid - 1);
                left = mid + 1;
            }
            else if (nums[mid] < nums[left]){
                if (tar > nums[mid] && tar <= nums[right]) return binarySearch(mid + 1, right);
                right = mid - 1;
            }
            else {
                boolean ans1 = find(left, mid - 1);
                boolean ans2 = find(mid + 1, right);
                return ans1 || ans2;
            }
        }       
        return false;
    }
    
    public boolean binarySearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == tar) return true;
            if (nums[mid] < tar)  left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
