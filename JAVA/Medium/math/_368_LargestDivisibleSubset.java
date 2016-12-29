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
 * 
 * 动态规划，
 * 需排序，后一个数能被前一个数整除，则必能被能整除前一个数的数整除
 * 用一个数组计算每一个数能被之前的数整除的最大数量
 * 用另一个数组记录最大set中前一个能被整除的数的下标
 */

public class _368_LargestDivisibleSubset {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        int len = nums.length;
        if (len == 0) return res;
        
        int[] count = new int[len];  // 保存该坐标的数最多能被多少个之前的数整除
        int[] pres = new int[len];   // 保存最大set的前一个数的下标
        Arrays.sort(nums);
        
        for (int idx = 0; idx < len; idx++) pres[idx] = -1; // 初始化上一个数的下标
        
        int maxNum = 0;
        int maxIdx = 0;
        
        for (int i = 1; i < len; i++) {
            int val = nums[i];  // 当前值
            for (int j = i - 1; j >= 0; j--) {
                int pre = nums[j]; // 之前的数
                if (val < pre) break;
                if (val % pre == 0) {
                    // 如果能被之前的数整除，则保存其中有最大set的数
                    int temp = count[j] + 1;
                    if (temp > count[i]) {
                        count[i] = temp;
                        pres[i] = j;
                        val /= pre;  // 排除重复计算，例如val == 16, 遇到8时 就可以停止检查之前的数
                    }
                    
                }
            }
            
            if (count[i] > maxNum) {
                // 记录最大set
                maxNum = count[i];
                maxIdx = i;
            }
        }

        do {
            res.add(0, nums[maxIdx]);
            maxIdx = pres[maxIdx];
        }while (maxIdx != -1);
        
        return res;
        
    }
}
