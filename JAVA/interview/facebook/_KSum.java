package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _KSum {
    
    public List<List<Integer>> fourSum(int[] nums, int k, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<Integer>();
        
        if (nums.length >= k) {
            Arrays.sort(nums);
            helper(nums, res, ls, 0, 0, k, target); 
        }

        return res;
        
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> ls, int left, int sum, int k, int target) {
        
        if (k == 2) {
            int right = nums.length - 1;
            while (left < right) {
                int val = sum + nums[left] + nums[right];
                if ( val == target) {
                    List<Integer> copy = new ArrayList<Integer>(ls);
                    copy.add(nums[left++]);
                    copy.add(nums[right--]);
                    res.add(copy);
                    while (left < right && nums[left - 1] == nums[left]) left++;
                    while (left < right && nums[right + 1] == nums[right]) right--;
                }
                else if (val < target) left++;
                else right--;
            }
        }
        else {
            for (int i = left; i < nums.length; i++) {
                if (i != left && nums[i] == nums[i - 1]) continue;
                ls.add(nums[i]);
                helper(nums, res, ls, i + 1, sum + nums[i], k - 1, target);
                ls.remove(ls.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
