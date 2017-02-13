package binarySearch;

/**
 * 如果有重复元素，无法通过比较中间值和边界值大小判断目标元素在中间值的左边或是右边
 * 当中间值和边界值相等时，narrow两边的指针
 */

public class _81_SearchinRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) return true;
            
            if (nums[left] == nums[right] && nums[left] == nums[mid]) {
                left++;
                right--;
            }
            else if (nums[mid] > nums[left]) {
                if (target > nums[mid] || target < nums[left]) left = mid + 1;
                else right = mid - 1;
            }
            else if (nums[mid] < nums[left]){
                if (target < nums[mid] || target > nums[right]) right = mid - 1;
                else left = mid + 1;
            }
            else left++;
            
        }
        
        return false;
        
    }
}
