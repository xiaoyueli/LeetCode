package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * 
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * Given nums = [5, 2, 6, 1]
 * 
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 * 
 * 思路：
 * 法1. binary search， 建一个数据结构用BS排序， 然后从后往前遍历原始数组，插入元素，计算其前有几个数小于它
 * 
 * 法2：merge sort：超时，思路就是计算前一半的数组的每一个元素大于多少后一半的数组，累计进入该数的count数组。注意，merge的是原始数组各元素的下标，需另开count数组，和position数组
 *
 */

public class _315_CountofSmallerNumbersAfterSelf {
    
    class Tree {
        int[] arr;
        int size;
        
        public Tree(int len) {
            arr = new int[len];
            size = 0;
        }
        
        public int insert(int val) {
            if (size == 0 ) {
                arr[size++] = val;
                return 0;
            }
            
            int left = 0;
            int right = size - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int num = arr[mid];
                
                if (num >= val ) right = mid - 1;
                else left = mid + 1;
                
            }
            
            move(left, val);
            size++;
            
            return left;
        }
        
        private void move(int sta, int val) {
            
            for (int idx = size - 1; idx >= sta; idx--) {
                arr[idx + 1] = arr[idx];
            }
            arr[sta] = val;
        }
    }
    
    
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> res = new ArrayList<Integer>();
        int len = nums.length;
        Tree tree = new Tree(len);
        
        for (int idx = len - 1; idx >= 0; idx--) {
            nums[idx] = tree.insert(nums[idx]);    
        }
        
        for (int num: nums) {
            res.add(num);
        }
        
        return res;
    }
    
    
    // merge sort
//    public List<Integer> countSmaller(int[] nums) {
//        
//        List<Integer> res = new ArrayList<Integer>();
//        
//        int len = nums.length;
//        int[] count = new int[len];
//        int[] pos = new int[len];
//        for (int i = 0; i < len; i++) pos[i] = i;
//        
//        megSort(nums, pos, count, 0, len - 1);
//        
//        for (int i: count) res.add(i);
//
//        return res;
//    }
//    
//    private void megSort(int[] nums, int[] pos, int[] count, int sta, int end) {
//        if (sta >= end) return;
//        
//        int mid = sta + (end - sta) / 2;
//        
//        megSort(nums, pos, count, sta, mid);
//        megSort(nums, pos, count, mid + 1, end);
//        
//        int[] temp = copy(pos);
//        
//        int i = sta;
//        int j = mid + 1;
//        int idx = sta;
//        int cnt = 0;
//        while (i <= mid && j <= end) {
//            if (nums[temp[i]] > nums[temp[j]]) {
//                pos[idx++] = temp[j++];
//                cnt++;
//            }
//            else {
//                count[temp[i]] += cnt;
//                pos[idx++] = temp[i++];
//            }
//        }
//        
// 
//        while (i <= mid) {
//            count[temp[i]] += cnt;
//            pos[idx++] = temp[i++];
//        }
//        
//        while (j <= end) {
//            pos[idx++] = temp[j++];
//        }
//        
//    }
//    
//    private int[] copy(int[] nums) {
//        
//        int len = nums.length;
//        int[] res = new int[len];
//        for (int i = 0; i < len; i++) res[i] = nums[i];
//        
//        return res;
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        _315_CountofSmallerNumbersAfterSelf test = new _315_CountofSmallerNumbersAfterSelf();
        test.countSmaller(new int[]{5, 2, 6, 1});

    }

}
