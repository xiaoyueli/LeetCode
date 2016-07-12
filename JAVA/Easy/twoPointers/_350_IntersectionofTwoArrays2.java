package twoPointers;

import java.util.Arrays;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * 
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, 
 * and the memory is limited such that you cannot load all elements into the memory at once?
 *
 */

public class _350_IntersectionofTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int cnt1 = 0;
        int cnt2 = 0;
        int idx = 0;
        int[] temp = new int[Math.max(nums1.length, nums2.length)];
        
        while (cnt1 < nums1.length && cnt2 < nums2.length) {
            if (nums1[cnt1] == nums2[cnt2]) {
                temp[idx++] = nums1[cnt1++];
                cnt2++;
            }
            else if (nums1[cnt1] < nums2[cnt2]) cnt1++;
            else cnt2++;
        }
        
        int[] res = new int[idx];
        for (int i = 0; i < idx; i++) res[i] = temp[i];
        return res;
    }
}
