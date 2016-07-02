package array;

public class _88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int idx = 0; idx < m; idx++) {
            temp[idx] = nums1[idx];
        }
        
        int idx = 0;
        int front1 = 0;
        int front2 = 0;
        while (front1 < m && front2 < n) {
            if (temp[front1] <= nums2[front2]) nums1[idx++] = temp[front1++];
            else nums1[idx++] = nums2[front2++];
        }
        
        while (front1 < m) nums1[idx++] = temp[front1++];
        while (front2 < n) nums1[idx++] = nums2[front2++];
    }
}
