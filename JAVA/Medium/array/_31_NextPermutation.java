package array;

public class _31_NextPermutation {
    
    public void nextPermutation(int[] nums) {
        
        int idx;
        for (idx = nums.length - 1; idx > 0; idx--) {
            if (nums[idx] > nums[idx - 1]) {
                int front = idx;
                while (front < nums.length) {
                    if (nums[front] <= nums[idx - 1]){
                        swap(front - 1, idx - 1, nums);
                        break;
                    }
                    front++;
                }
                if (front == nums.length) swap(idx - 1, front - 1, nums);
                swapSubArray(idx, nums.length - 1, nums);
                break;
                
            }
        }
        
        if (idx == 0) {
            swapSubArray(0, nums.length - 1, nums);
        }
    
    }
    
    public void swapSubArray(int front, int rear, int[] arr) {
        while (front < rear) {
            swap(front, rear, arr);
            front++;
            rear--;
        }
    }
    
    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
