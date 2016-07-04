package array;

public class _153_FindMinimuminRotatedSortedArray {
    
    public int findMin(int[] nums) {
   
        int front = 0;
        int rear = nums.length - 1;

        while (front < rear) {
            int mid = (front + rear) / 2;
            if (nums[mid] < nums[rear]) rear = mid;
            else front = mid + 1;
            
        }
        
        return nums[front];
    }
    
}
