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
        
        int i1 = m - 1;
        int i2 = n - 1;
        int i = m + n - 1;
        
        while (i1 >= 0 && i2 >= 0) {
            int v1 = nums1[i1];
            int v2 = nums2[i2];
            if (v1 > v2) {
                nums1[i--] = v1;
                i1--;
            }
            else {
                nums1[i--] = v2;
                i2--;
            }
        }
        
        while (i2 >= 0) nums1[i--] = nums2[i2--];
        
    }
}
