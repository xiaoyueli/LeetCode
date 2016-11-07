package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组 {2,3,5} 目标  7
 * 遍历模型：
 * 0 -> 2 (1)
 * 2 -> 2 2 (2)
 * 2 2 -> 2 2 2 (3)
 * 2 2 2 -> 2 2 2 2 -> 2 2 2 
 * 2 2 2 -> 2 2 2 3 -> 2 2 2 
 * 2 2 2 -> 2 2 2 5 -> 2 2 2
 * 递归返回上一层  3， 移除最后一个元素2 -> 2 2 
 * 2 2 -> 2 2 3 满足 -> 2 2
 * 2 2 -> 2 2 5 -> 2 2
 * 递归返回上一层  2， 移除最后一个元素2 -> 2
 * 2 -> 2 3 (4)
 * 2 3 -> 2 3 3 -> 2 3
 * 2 3 -> 2 3 5 -> 2 3
 * 递归返回上一层  4， 移除最后一个元素2 -> 2
 * 2 -> 2 5 满足 -> 2
 * 递归返回上一层  1， 移除最后一个元素2 -> 0 退出     
 */

public class _39_CombinationSum {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<Integer>();
        
        helper(res, ls, candidates, 0, 0, target);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(ls));
            return;
        }
        
        if (sum > target || pos == nums.length) return;
        
        ls.add(nums[pos]);
        helper(res, ls, nums, pos, sum + nums[pos], target);
        ls.remove(ls.size() - 1);
        helper(res, ls, nums, pos + 1, sum, target);
        
    }
    
//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> list = new ArrayList<Integer>();
//    int tar;
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        tar = target;
//        search(candidates, 0, 0);
//        return res;
//    }
//    
//    public void search(int[] nums, int sum, int cur) {
//        if (sum == tar) {
//            List<Integer> newOne = new ArrayList<Integer>(list);
//            res.add(newOne);
//            return;
//        }
//        else if (sum > tar) return;
//        
//        for (int idx = cur; idx < nums.length; idx++) {
//            list.add(nums[idx]);
//            sum += nums[idx];
//            // 递归相加当前值， 直到找到或超过目标值
//            search(nums, sum, idx);
//            // 因为找到时sum是>=的状态
//            // 因此需要从和中减去最后一个加入的值， 并移除
//            // 移动到下一个值
//            // 本轮所有值都尝试完毕后，递归返回上一层
//            sum -= list.get(list.size() - 1);
//            list.remove(list.size() - 1);
//            
//        }
//    }
}
