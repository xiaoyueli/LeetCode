package array;
/**
 * 根据新乘入元素的正负号分情况处理
 */
public class _152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        

    int maxVal = 1;
    int minVal = 1;
    int ans = Integer.MIN_VALUE;
    
    for (int idx = 0; idx < nums.length; idx++) {
        
        if (nums[idx] == 0) {
            // 遇0后，重新计算累计值
            ans = Math.max(ans, 0);
            maxVal = 1;
            minVal = 1;
        }
        else if (nums[idx] > 0) {
            // 如果遇大于0的元素累计乘积为单调函数
            // 用max函数更新最大乘积
            maxVal *= nums[idx];
            minVal *= nums[idx];
            ans = Math.max(maxVal, ans);
        }
        else {
            // 遇小于0的数，若之前乘积值为负数，表现为MinVal
            // 若之前乘积值为正数，表现为MaxVal
            
            // 只有当之前为负数时，才有可能更新最大乘积值
            ans = Math.max(ans, minVal * nums[idx]);
            int oldmin = minVal;
            // 新的最小乘积值建立于之前为正数的基础上
            minVal = maxVal * nums[idx];
            // 若之前为负数，新的乘积值会更大
            // 若之前为正数， 新的乘积值不会超过1
            maxVal = Math.max(1, oldmin * nums[idx]);
            
        }
    }
    
    return ans;
    
    }

}
