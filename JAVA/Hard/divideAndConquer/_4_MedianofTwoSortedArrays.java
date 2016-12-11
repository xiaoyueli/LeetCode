package divideAndConquer;

/**
 * 
 * @author xiaoyue
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

    Example 1:
    nums1 = [1, 3]
    nums2 = [2]
    
    The median is 2.0
    Example 2:
    nums1 = [1, 2]
    nums2 = [3, 4]
    
    The median is (2 + 3)/2 = 2.5
 *
 * 思路：
 * 找两个数组合并后第K个元素
 * 将K分成2半，分别在A,B数组中找第K/2个元素，并比较大小
 * 1，如果A数组的K/2个元素小于B数组中的K/2个元素，则A数组中的前K/2个元素一定属于前K个元素。将其剔除，在AB数组中找剩下的第K/2大的元素
 * 2，在B数组中反之亦然
 * 3，如果A中的第K/2等于B中的K/2，则该数即为2个数组中合并后第K大的元素。
 * 
 * 细节：
 * 1，总是让第一个数组短于第2个数组
 * 2，判断合并和数组长度奇偶分情况求K
 * 3，当第一个数组有效长度为0时，返回第二个数组的第K个值
 * 4，当K==1时，返回两个数组中第一个值的较小值。
 */

public class _4_MedianofTwoSortedArrays {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int total = nums1.length + nums2.length;
        if ((total & 1) == 0) return (helper(nums1, 0, nums2, 0, total / 2) + helper(nums1, 0, nums2, 0, total / 2 + 1)) / 2;
        else return helper(nums1, 0, nums2, 0, total / 2 + 1);
        
    }
    
    private double helper(int[] nums1, int pos1, int[] nums2, int pos2, int kth) {
        int len1 = nums1.length - pos1;
        int len2 = nums2.length - pos2;
        if (len1 > len2) return helper(nums2, pos2, nums1, pos1, kth);
        if (len1 == 0) return nums2[pos2 + kth - 1];

        if (kth == 1) return Math.min(nums1[pos1], nums2[pos2]);
        
        int half1 = Math.min(kth / 2, len1);
        int half2 = kth - half1;
        
        if (nums1[pos1 + half1 - 1] < nums2[pos2 + half2 - 1]) return helper(nums1, pos1 + half1, nums2, pos2, kth - half1);
        if (nums1[pos1 + half1 - 1] > nums2[pos2 + half2 - 1]) return helper(nums1, pos1, nums2, pos2 + half2, kth - half2);
        
        return nums1[pos1 + half1 - 1];
        
    }

}
