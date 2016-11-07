package tree;

/**
 * 
 * @author xiaoyue
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 * 
 * 思路。segment tree, 将数组分成两段循环递归
 * 注意建立的segment tree 的大小需要是 n 个 leaf 为最后一层时的满二叉树大小 + 1；
 * 
 *
 */

public class _307_RangeSumQueryMutable {
    
    int[] segTree;
    int[] nums;
    int len;
    
    public _307_RangeSumQueryMutable(int[] nums) {
        
        this.nums = nums;
        len = nums.length;
        
        // 计算segment tree的大小，其值等一leaf为len 的满二叉树大小，因为数组可能不会被填满
        int size = (int)Math.pow(2, Math.ceil(Math.log(len) / Math.log(2)) + 1); 
        segTree = new int[size];
        
        buildTree(nums, segTree, 0, len - 1, 1);
        
    }
    
    private int buildTree(int[] ori, int[] res, int sta, int end, int idx) {
        if (sta == end) {
            res[idx] = ori[sta];
            return ori[sta];
        }
        if (sta > end) return 0;
        
        int mid = sta + (end - sta) / 2;
        int sum = buildTree(ori, res, sta, mid, idx * 2);
        sum += buildTree(ori, res, mid + 1, end, idx * 2 + 1);
        
        res[idx] = sum;
        return sum;
    }

    void update(int i, int val) {
        
        int diff = val - nums[i];
        nums[i] = val;
        
        updateHelper(0, len - 1, i, 1, diff); 
        
    }
    
    private void updateHelper(int sta, int end, int target, int idx, int diff) {
        if (sta == end && sta == target) {
            segTree[idx] += diff;
            return;
        }
        
        if (sta >= end || target > end || target < sta) return;
        
        segTree[idx] += diff;
        
        int mid = sta + (end - sta) / 2;
        updateHelper(sta, mid, target, idx * 2, diff);
        updateHelper(mid + 1, end, target, idx * 2 + 1, diff);
        
    }

    public int sumRange(int i, int j) {
        
        return sumRangeHelper(0, len - 1, i, j, 1);

    }
    
    private int sumRangeHelper(int sta, int end, int i, int j, int idx) {
        if (i <= sta && j >= end) {
            return segTree[idx];
        }
        
        if (sta > end || j < sta || i > end) return 0;
        
        int mid = sta + (end - sta) / 2;
        
        int sum = sumRangeHelper(sta, mid, i, j, idx * 2);
        sum += sumRangeHelper(mid + 1, end, i, j, idx * 2 + 1);
        
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
