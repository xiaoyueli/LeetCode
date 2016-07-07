package hashtable;

import java.util.Arrays;

public class _349_IntersectionofTwoArrays {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int idx1 = 0;
        int idx2 = 0;
        
        int[] tempRe = new int[Math.max(nums1.length, nums2.length)];
        int idx = 0;
        int sumNum = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                if (idx == 0 || nums1[idx1] != tempRe[idx - 1]) {
                    tempRe[idx++] = nums1[idx1];
                    sumNum++;
                }
                idx1++;
                idx2++;
            }
            else if (nums1[idx1] < nums2[idx2]) idx1++;
            else idx2++;
        }
        
        int[] res = new int[sumNum];
        for (int i = 0; i < sumNum; i++) res[i] = tempRe[i];
        
        return res;
    }
}
