package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
  	[1,1,2],
  	[1,2,1],
  	[2,1,1]
 * ]
 * 
 * 思路：
 * 对数组排序
 * 用一个boolean数组来记录当前元素有没有被访问过
 * 被访问过的就不再进行递归， 保证每一个排列没有重复使用的元素
 * 如果是当前元素和前一个元素相同，且前一个元素还未被访问过，也不再递归，保证当前值在当前位置只使用一次，即排除相同数值的元素在因顺序不同而被选入
 * 
 * 
 * @author xiaoyue
 *
 */
public class _47_Permutations2 {
	
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        
        Arrays.sort(nums);
        helper(res, lst, nums, visited);
        
        return res;
        
    }
    
    private void helper(List<List<Integer>> res, List<Integer> lst, int[] nums, boolean[] visited) {
        
        int len = nums.length;
        if (lst.size() == len) {
            List<Integer> copy = new ArrayList<Integer>(lst);
            res.add(copy);
            return;
        }
        
        for (int idx = 0; idx < len; idx++) {
            if (visited[idx] || idx != 0 && nums[idx] == nums[idx - 1] && !visited[idx - 1]) continue;
            visited[idx] = true;
            lst.add(nums[idx]);
            helper(res, lst, nums, visited);
            lst.remove(lst.size() - 1);
            visited[idx] = false;
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
