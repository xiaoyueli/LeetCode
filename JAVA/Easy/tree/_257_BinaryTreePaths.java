package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 * 
 *    1
    /   \
   2     3
     \
      5
   
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]    
 *
 * 递归左右子树
 */

public class _257_BinaryTreePaths {
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> res = new ArrayList<String>();
        
        helper(root, res, "");
        
        return res;
        
    }
    
    private void helper(TreeNode rt, List<String> res, String str) {
        if (rt == null) return;

        if (rt.left == null && rt.right == null) {
            res.add(str + rt.val);
            return;
        }
        
        helper(rt.left, res, str + rt.val + "->");
        helper(rt.right, res, str + rt.val + "->");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
