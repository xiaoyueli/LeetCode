package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, 
 * find the largest subset such that every pair (Si, Sj) of elements 
 * in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * nums: [1,2,3]
 * Result: [1,2] (of course, [1,3] will also be ok)
 * 
 * Example 2:
 * nums: [1,2,4,8]
 * Result: [1,2,4,8]
 * 
 * 排序之后两重循环
 * j < i;
 * if nums[i] % nums[j] == 0 , counts[i] = counts[j] + 1;
 */

public class _368_LargestDivisibleSubset {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> lst = new ArrayList<Integer>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 1) return lst;
        int[] counts = new int[len];
        int[] parents = new int[len];
        
        parents[0] = -1;
        int maxSize = 0;
        int maxIdx = -1;
        
        for (int idx = 1; idx < len; idx++) {
            int curVal = nums[idx];
            parents[idx] = -1;
            for (int curIdx = 0; curIdx < idx; curIdx++) {
                int preVal = nums[curIdx];
                if (curVal % preVal == 0 && counts[curIdx] + 1 > counts[idx]) {
                    counts[idx] = counts[curIdx] + 1;
                    parents[idx] = curIdx;
                }
            }
            
            if (counts[idx] > maxSize) {
                maxSize = counts[idx];
                maxIdx = idx;
            }
        }
        
        if (maxIdx == -1) {
            lst.add(nums[0]);
        }
        else {
            do {
                lst.add(nums[maxIdx]);
                maxIdx = parents[maxIdx];
            }while (maxIdx != -1);
        }
        
        return lst; 
        
    }
}
