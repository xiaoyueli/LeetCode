package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
 *	]
 * @author xiaoyue
 *
 */

public class _77_Combinations {
	
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<Integer>();
        
        helper(res, lst, 1, n, k);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> lst, int num, int n, int k) {
        if (lst.size() == k) {
            res.add(new ArrayList<Integer>(lst));
            return;
        }
        
        if (num > n) return;
        
        lst.add(num);
        helper(res, lst, num + 1, n, k);
        lst.remove(lst.size() - 1);
        helper(res, lst, num + 1, n, k);
    }

}
