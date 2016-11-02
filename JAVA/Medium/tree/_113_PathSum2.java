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
        List<Integer> ls = new ArrayList<Integer>();
        
        helper(res, ls, root, sum, 0);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> ls, TreeNode root, int sum, int cur) {
        
        if (root == null) return;
        
        ls.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (sum == cur + root.val) {
                res.add(new ArrayList<Integer>(ls));
            }
            ls.remove(ls.size() - 1);
            return;
        }
        
        helper(res, ls, root.left, sum, cur + root.val);
        helper(res, ls, root.right, sum, cur + root.val);
        
        ls.remove(ls.size() - 1);
        
    }

}
