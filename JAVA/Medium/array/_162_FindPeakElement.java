package array;

/**
 *  题目规定左右边界都是无穷小
 */
public class _162_FindPeakElement {
    
    public int findPeakElement(int[] nums) {
        // 二分法查找
        // 初始情况下，从中间开始，如果存在中间值的左边比中间值大，
        // 那么数组的左边一定存在peak number， 因为左边界是无穷小
        // 然后二分法更新新的左右边界值
        // 右边同理
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
            
        }
        
        return left;
    }
    
    public int findPeakElement2(int[] nums) {
        // 所有从开始遍历时，只需比较比右边大的元素
        // 不会出现左边比右边大，还没有返回的情况
        
        for (int idx = 0; idx < nums.length - 1; idx++) {
            if (nums[idx] > nums[idx + 1]) return idx;
        }
        
        return nums.length - 1;
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
