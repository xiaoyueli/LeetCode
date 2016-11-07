package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSum2 {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        helper(res, ls , candidates, 0, 0, target);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int sum, int pos, int target) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(ls));
            return;
        }
        
        if (sum > target) return;
        if (pos == nums.length) return;
        
        ls.add(nums[pos]);
        helper(res, ls, nums, sum + nums[pos], pos + 1, target);
        ls.remove(ls.size() - 1);
        while (pos < nums.length - 1 && nums[pos] == nums[pos + 1]) pos++; 
        helper(res, ls, nums, sum, pos + 1, target);
        
    }
    
//    List<List<Integer>> ans = new ArrayList<>();
//    List<Integer> lst = new ArrayList<Integer>();
//    int target;
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        this.target = target;
//        search(candidates, 0, 0);
//        return ans;
//    }
//    
//    public boolean search(int[] nums, int sum, int col) {
//        boolean flag = false;
//        if (sum == target) {
//            List<Integer> newOne = new ArrayList<Integer>(lst);
//            ans.add(newOne);
//            return true;
//        }
//        
//        if (sum > target) {
//            return false;
//        }
//        
//        for (int idx = col; idx < nums.length; idx++) {
//            
//            // flag 为true 则表示当前元素有正确解
//            // 若再遇到同样的元素则跳过，否则会产生重复
//            if (flag && nums[idx - 1] == nums[idx]) continue;
//            sum += nums[idx];
//            lst.add(nums[idx]);
//            
//
//            boolean next = search(nums, sum, idx + 1);
//            // 如果本次递归有正确解，标记为true
//            if (next) flag = true;
//            sum -= lst.get(lst.size() - 1);
//            lst.remove(lst.size() - 1);
//        }
//        
//        return flag;
//
//    }
}
