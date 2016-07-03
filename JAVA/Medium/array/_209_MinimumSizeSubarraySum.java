package array;

/**
 * 首先从头开始扫描数组，计算出满足条件的最短数组
 * 如果有满足条件的数组，保存长度，然后从左开始减少数组长度并减去其值
 * 一旦减去左边数组长度后不再满足条件，重新向右推进，计算出新的满足条件的数组
 * 如果满足条件的新数组长度小于目前最短数组，更新为最新的最短数组长度
 * 直到把数组扫描完毕
 */

public class _209_MinimumSizeSubarraySum {
    
    public int minSubArrayLen(int s, int[] nums) {
        
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int sum = 0;
        
        while (right < nums.length) {
            
            // scan the array by order to find out the sub array 
            // whose sum at least >= s
            while (sum < s && right < nums.length) {
                sum += nums[right++];
            }
            
            // decrease the left of sub array to find out
            // the valid shortest sub array
            // once the sum less than s go back to the most outside loop
            // to update a new valid sub array
            // if the new length less than old one update it
            while (sum >= s) {
                
                // store the valid min length
                length = Math.min(length, right - left);
                sum -= nums[left++];
            }
        }

        if (length == Integer.MAX_VALUE) length = 0;
        return length;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _209_MinimumSizeSubarraySum test = new _209_MinimumSizeSubarraySum();
        int result = test.minSubArrayLen(4, new int[]{1, 4, 4});
        System.out.println(result);
    }

}
