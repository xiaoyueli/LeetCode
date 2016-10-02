package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: 
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
 * that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 *      _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
 * 
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
 * Another example is LCA of nodes 5 and 4 is 5, 
 * since a node can be a descendant of itself according to the LCA definition
 * 
 * 重复数据的情况？
 */

public class _236_LowestCommonAncestorofaBinaryTree {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> seq1 = new ArrayList<TreeNode>();
        List<TreeNode> seq2 = new ArrayList<TreeNode>();
        
        search(root, p, seq1);
        search(root, q, seq2);
        
        int idx = 0;
        int len = Math.min(seq1.size(), seq2.size());
        while (idx < len) {
            TreeNode cur1 = seq1.get(idx);
            TreeNode cur2 = seq2.get(idx);
            
            if (cur1.val != cur2.val) break;
            idx++;
        }
        
        return seq1.get(idx - 1);
        
    }
    
    public boolean search(TreeNode root, TreeNode td, List<TreeNode> lst) {
                

        if (root == td) {
            lst.add(root);
            return true;
        }
        
        if (root != null) {
            lst.add(root);
            if (search(root.left, td, lst)) return true;
            if (search(root.right, td, lst)) return true;
            lst.remove(lst.size() - 1);
            
        }

        return false;
    }

}
