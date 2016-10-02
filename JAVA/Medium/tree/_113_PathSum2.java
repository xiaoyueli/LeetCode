package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, 
 * find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 *            5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
        
 * return
 * [
   [5,4,11,2],
   [5,8,4,5]
   ]
 */

public class _113_PathSum2 {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<Integer>();
        helper(root, 0, sum, sub, res);
        
        return res;
        
    }
    
    public void helper(TreeNode td, int cur, int sum, List<Integer> list, List<List<Integer>> res) {
        if (td == null) return;
        cur += td.val;
        list.add(td.val);
        if (td.left == null && td.right == null) {
            if (cur == sum) {
                List<Integer> newOne = new ArrayList<Integer>(list);
                res.add(newOne);
            }
            return;
        }
        
        if (td.left != null) {
            helper(td.left, cur, sum, list, res);
            list.remove(list.size() - 1);
        }
        
        if (td.right != null) {
            helper(td.right, cur, sum, list, res);
            list.remove(list.size() - 1);
        }
        
    }

}
