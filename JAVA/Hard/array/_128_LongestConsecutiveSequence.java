package array;

import java.util.HashSet;

/**
 * 
 * @author xiaoyue
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    
    For example,
    Given [100, 4, 200, 1, 3, 2],
    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
    
    Your algorithm should run in O(n) complexity.
 * 思路：
 * 用hashset, 遇到当前可删除元素，就删除其连续小于它和连续大于它的元素，更新最大长度
 */

public class _128_LongestConsecutiveSequence {
    
    public int longestConsecutive(int[] nums) {
        
        int max = 0;
        
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num: nums) set.add(num);
        
        for (int num: nums) {
            if (set.remove(num)) {
                int val = num;
                int len = 1;
                
                while (set.remove(--val)) len++;
                val = num;
                while (set.remove(++val)) len++;
                
                if (len > max) max = len;
            }
        }
        
        return max;
    }

}
