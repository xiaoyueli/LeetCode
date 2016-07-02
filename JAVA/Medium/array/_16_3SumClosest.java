package array;

import java.util.Arrays;

public class _16_3SumClosest {
    
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int minDif = Integer.MAX_VALUE;
        int result = target;
        for (int idx = 0; idx < nums.length - 2; idx++) {
            int left = idx + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[idx] + nums[left] + nums[right];
                if (Math.abs(sum - target) < minDif) {
                    minDif = Math.abs(sum - target);
                    result = sum;
                }
                
                if (minDif == 0) return target;
                if (sum > target) right--;
                if (sum < target) left++;
            }
            
            
        }
        return result;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
