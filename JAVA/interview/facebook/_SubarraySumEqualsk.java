package facebook;

public class _SubarraySumEqualsk {
    
    public boolean solve(int[] nums, int k) {
        
        int sum = 0;
        int left = 0;
        int right = 0;
        
        while (right < nums.length) {
            
            while (sum < k && right < nums.length) sum += nums[right++];
            
            if (sum == k) return true;
            
            while (sum > k && left < right) sum -= nums[left++];
            
            if (sum == k) return true;
        }
        
        return false;
    }
    
    public boolean solve2(int[] nums, int k) {
        
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (sums[i] == k) return true;
            for (int j = i + 1; j < nums.length; j++) {
                if (sums[j] - sums[i] == k) return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _SubarraySumEqualsk test = new _SubarraySumEqualsk();
        int[] nums = new int[]{2,-3,1,-5,6,-13,-7,8,5,-9,10};
        
        System.out.println(test.solve2(nums, -15));

    }

}
