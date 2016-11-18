package sort;

import java.util.Arrays;

/**
 * Given an unsorted array nums, 
 * reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * 
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * 思路：
 * 方法1：将数组排序后，复制数组，把数组分成前后两段，从每一段的最后往前交替插入原来的数组 O（NlogN）
 * 
 * 方法2：整体思路同上，只是排序自己写quicksort找到中间位子的那个数，然后开新数组，小于medium的放前，大于的放后，中间放medium，之后同上
 *
 */

public class _324_WiggleSort2 {
    
    public void wiggleSort(int[] nums) {
        
        Arrays.sort(nums);
        int[] copy = nums.clone();
        
        int length = nums.length;
        int small = (length - 1) / 2;
        int big = length - 1;
        
        boolean flag = true;
        for (int idx = 0; idx < length; idx++) {
            if (flag) nums[idx] = copy[small--];
            else nums[idx] = copy[big--];
            flag = !flag;
        }
        
    }
    
    
    // average O(n)
    public void wiggleSort1(int[] nums) {
        
        int length = nums.length;
        int medium = findMedium(nums, 0, length - 1, length / 2);
        
        int[] temp = new int[length];
        int small = 0;
        int big = length - 1;
        
        for (int idx = 0; idx < length; idx++) {
            if (nums[idx] < medium) temp[small++] = nums[idx];
            else if (nums[idx] > medium) temp[big--] = nums[idx];
        }
        
        for (int idx = small; idx <= big; idx++) temp[idx] = medium;
        
        small = (length - 1) / 2;
        big = length - 1;
        boolean flag = true;
        
        for (int idx = 0; idx < length; idx++) {
            if (flag) nums[idx] = temp[small--];
            else nums[idx] = temp[big--];
            flag = !flag;
        }
        
    }
    
    private int findMedium(int[] nums, int sta, int end, int mid) {
        
        int pivot = partition(nums, sta, end);
        if (pivot == mid) return nums[pivot];
        
        if (pivot < mid) return findMedium(nums, pivot + 1, end, mid);
        else return findMedium(nums, sta, pivot - 1, mid);
    }
    
    private int partition(int[] nums, int sta, int end) {
        
        if (sta >= end) return sta;
        int val = nums[sta];
        
        int small = sta + 1;
        int big = end;
        int idx = sta + 1;
        while (idx <= big) {
            
            if (nums[idx] < val) {
                swap(nums, small, idx);
                small++;
                idx++;
            }
            else if (nums[idx] > val) {
                swap(nums, idx, big);
                big--;
            }
            else idx++;
        }
        
        swap(nums, sta, big);
        
        return big;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {

    }
}
