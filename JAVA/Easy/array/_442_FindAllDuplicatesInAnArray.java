package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

    Find all the elements that appear twice in this array.
    
    Could you do it without extra space and in O(n) runtime?
    
    Example:
    Input:
    [4,3,2,7,8,2,3,1]
    
    Output:
    [2,3]
    
    思路：
    将当前元素指向的元素设为负数，
    如果某一元素出现过两次，则会指向同一元素。即如果被指向的元素已经为负数，则指向它的元素出现过两次
 */

public class _442_FindAllDuplicatesInAnArray {
    
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) res.add(index + 1);
            else nums[index] = -nums[index];
        }

        return res;
        
    }

}
