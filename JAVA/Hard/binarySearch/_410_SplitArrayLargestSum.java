package binarySearch;

/**
 * 
 * @author xiaoyue
 * 
 * Given an array which consists of non-negative integers and an integer m, 
 * you can split the array into m non-empty continuous subarrays. 
 * Write an algorithm to minimize the largest sum among these m subarrays.

    Note:
    Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.
    
    Examples:
    
    Input:
    nums = [7,2,5,10,8]
    m = 2
    
    Output:
    18
    
    Explanation:
    There are four ways to split nums into two subarrays.
    The best way is to split it into [7,2,5] and [10,8],
    where the largest sum among the two subarrays is only 18.
 * 
 * 思路：
 * 最小化的最大subsum的值一定是介于最大数与所有数的sum之间的。因此可以用二分法找这个最小的最大sum
 * 重点就在于check这个mid值最为目标sum的时候是否能有效划分出m个subarray
 * 
 * isValid的逻辑在于，从0开始不断累加值，超过目标sum。就算做划分出一段（也就是按值划分）, 然后sum 从当前数开始，以保证之前那一段的sum 小于目标sum。
 * 如果划分出的片段已经达到M。还没有划分完，说明我们选的目标sum值过小，需加大。都在上限变小
 */

public class _410_SplitArrayLargestSum {
    
    public int splitArray(int[] nums, int m) {
        
        long max = 0;
        long min = 0;
        
        for (int num: nums) {
            min = Math.max(num, min);
            max += num;
        }
        
        while (min < max) {
            long mid = min + (max - min) / 2;
            
            if (isValid(nums, mid, m)) max = mid;
            else min = mid + 1;
        }
        
        return (int)max;

    }
    
    private boolean isValid(int[] nums, long max, int m) {
        
        int cnt = 0;
        int sum = 0;
        
        for (int num: nums) {
            sum += num;
            
            if (sum > max) {
                sum = num;
                cnt++;
                if (cnt == m) return false;
            }
        }
   
        return true;

    }

}
