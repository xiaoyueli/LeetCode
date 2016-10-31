package array;

/**
 * Given an array of integers, 
 * find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t 
 * and the difference between i and j is at most k.
 * 
 * 保持一个数量为K的二叉树
 * 将当前值与树内元素进行比较
 */

import java.util.SortedSet;
import java.util.TreeSet;

public class _220_ContainsDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
      
        SortedSet<Integer> set = new TreeSet<Integer>();
        if (nums.length <= 1) return false;
        
        for (int idx = 0; idx < nums.length; idx++) {
            
            int num = nums[idx];
            SortedSet<Integer> subset = set.headSet(num);   // 值小于num的元素集
            if (!subset.isEmpty() && subset.last() + t >= num) return true;
            subset = set.tailSet(num);  // 值大于num的元素集
            if (!subset.isEmpty() && subset.first() - t <= num) return true;
                        
            set.add(num);
            if (idx >= k) set.remove(nums[idx - k]); // 保持set数量不超过K
            
        }
        
        return false;
        
        
        
    }
}

