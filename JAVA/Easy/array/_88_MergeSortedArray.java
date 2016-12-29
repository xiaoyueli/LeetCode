package array;

/**
 * 
 * @author xiaoyue
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * 思路：
 * 1.in place:从后往前填充
 * 
 * 2.用额外的空间
 *
 */

public class _88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int idx = m + n - 1;
        
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) nums1[idx--] = nums1[m--];
            else nums1[idx--] = nums2[n--];
        }
        
        while (n >= 0) nums1[idx--] = nums2[n--];
        
    }
}
