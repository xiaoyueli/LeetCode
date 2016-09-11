package heap;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * 
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * Return: [1,2],[1,4],[1,6]
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * Example 2:
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * Return: [1,1],[1,1]
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * Example 3:
 * Given nums1 = [1,2], nums2 = [3],  k = 3 
 * Return: [1,3],[2,3]
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 * 
 * 思路（未使用heap）：类似动态规划
 * 每次遍历数组1，
 * 需要额外的一个数组来记录数组1中每一个数对应于数组2中的最小数组对下标
 * 找到每一轮的最小数组对加入List，
 * 记录该数组对数组1中的下标，更新该下标对应的数组2中的下标：+1；
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _373_FindKPairswithSmallestSums {
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<int[]> res = new ArrayList<int[]>();
        
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int cnt = 0;
        int target = Math.min(k, len1 * len2);
        int[] minIndice = new int[len1]; // 数组1中每一个数对应的数组2的最小值下标
        
        while (cnt < target) {
            
            
            int minVal = Integer.MAX_VALUE;
            int minIdx = 0;
            for (int idx = 0; idx < len1; idx++) {
                if (minIndice[idx] == len2) continue; // 数组1中该数对应的数组2的每一个数已经加入list，则skip
                int cur1 = nums1[idx]; // 数组1的数值
                int cur2 = nums2[minIndice[idx]];  // 该数对应在数组2中的最小值
                if (cur1 + cur2 < minVal) {
                    // 记录本轮最小val, 记录本轮最小val在数组1中的位置
                    minVal = cur1 + cur2;
                    minIdx = idx;
                }
                
            } 
            
            // 将本轮的最小pair加入list;
            res.add(new int[]{nums1[minIdx], nums2[minIndice[minIdx]]});
            minIndice[minIdx]++;  //将对应的数组2中的下标+1
            cnt++;
            
        }
        
        return res;
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
