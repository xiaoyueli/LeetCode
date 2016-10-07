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
        
        if (root == null) return res;

        helper(root, "", res);
        
        return res;
        
    }
    
    public void helper(TreeNode td, String str, List<String> list) {
        
        if (td.left == null && td.right == null) {
            list.add(str + td.val);
            return;
        }
        
        if (td.left != null) {
            helper(td.left, str + td.val + "->", list);
        }
        if (td.right != null) {
            helper(td.right, str + td.val + "->", list);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
