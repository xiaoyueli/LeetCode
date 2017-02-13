package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_Subsets2 {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        
        int dup = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) dup++;
            else dup = 0;
            List<List<Integer>> tep = new ArrayList<>();
            for (List<Integer> ls: res) {
                tep.add(ls);
                if (dup > 0 && (ls.size() < dup || ls.get(ls.size() - dup) != nums[i])) continue; 
                // 如果是duplicate,则只在包含大于等于当前duplicate 长度的list中形成新的list
                //例如，当前num 是第四个duplicate, 12222, 则只在已经含有3个2的 list后加入2形成新的list，否则就会构成重复
                
                List<Integer> copy = new ArrayList<Integer>(ls);
                copy.add(nums[i]);
                tep.add(copy);
            }
            res = tep;
        }
        
        return res;
    }
    
    
    // bc
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        List<Integer> ls = new ArrayList<Integer>();
        helper(nums, res, ls, 0);
        
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> ls, int pos) {
        if (pos == nums.length) return;
        
        for (int i = pos; i < nums.length; i++) {
            ls.add(nums[i]);
            List<Integer> copy = new ArrayList<Integer>(ls);
            res.add(copy);
            helper(nums, res, ls, i + 1);
            ls.remove(ls.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
    }
       
   }
