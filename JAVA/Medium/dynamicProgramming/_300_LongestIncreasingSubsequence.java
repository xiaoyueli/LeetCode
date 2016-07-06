package dynamicProgramming;

import java.util.ArrayList;

/**
 *  建一个队列，依次加入元素
 *  新元素大于最后一个元素就加入，这样保证队列升序长长
 *  新元素小于最后一个元素就替换队列中第一个比它大的元素
 *  这样就不会影响已有的最长升序队列长度，并不断更新队列
 *  O(NlogN)
 */

public class _300_LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums) {
        
        if (nums.length == 0) return 0;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        
        for (int idx = 1; idx < nums.length; idx++) {
            int lastNum = list.get(list.size() - 1);
            
            if (nums[idx] > lastNum) list.add(nums[idx]);
            else replaceElement(list, nums[idx]);
        }
        
        return list.size();
    }
    
    public void replaceElement(ArrayList<Integer> lst, int num) {
        // 二分法查找
        
        int left = 0;
        int right = lst.size() - 1;
        
        while (left <= right) {
            int mid = (right + left) / 2;
            if (lst.get(mid) == num) return;
            if (lst.get(mid) > num) right = mid - 1;
            else left = mid + 1;
        }
        
        lst.set(left, num);
    }
}