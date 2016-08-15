package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) 
 * that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 * 1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 * 
 * 递归，求左右子树的集合，
 * 然后将每一种左子树对应每一种右子树拼接到root
 * 
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _95_UniqueBinarySearchTrees2 {
    
    public List<TreeNode> generateTrees(int n) { 

        if (n == 0) return new ArrayList<TreeNode>();
        return getTree(1, n);   
    }
    
    public List<TreeNode> getTree(int floor, int ceiling) {
        
        List<TreeNode> trees = new ArrayList<TreeNode>();
        
        if (floor > ceiling) {
            trees.add(null);
            return trees;
        }
        
        for (int root = floor; root <= ceiling; root++) {
            List<TreeNode> ltree = getTree(floor, root - 1);
            List<TreeNode> rtree = getTree(root + 1, ceiling);

            for (TreeNode lt: ltree) {
                for (TreeNode rt: rtree) {
                    TreeNode node = new TreeNode(root);
                    node.left = lt;
                    node.right = rt;
                    trees.add(node);
                }
            }  
        }        
        return trees;
        
    }
    
        //第一遍写得记录
//    public List<TreeNode> generateTrees(int n) {
//        
//        List<TreeNode> res = new ArrayList<TreeNode>();
//        
//        if (n == 0) return res;
//        res.addAll(getTree(1, 2, n));
//        for (int idx = 2; idx <= n; idx++) {
//            res.addAll(getTree(idx, 1, n));
//        }
//        
//        return res;
//        
//    }
//    
//    public List<TreeNode> getTree(int root, int floor, int ceiling) {
//        
//        
//        List<TreeNode> ltree = new ArrayList<TreeNode>();
//        List<TreeNode> rtree = new ArrayList<TreeNode>();
//        List<TreeNode> trees = new ArrayList<TreeNode>();
//        
//        if (floor > ceiling) {
//            trees.add(new TreeNode(root));
//            return trees;
//        }
//        
//        if (floor < root) ltree.addAll(getTree(floor, floor + 1, root - 1));
//        for (int left = floor + 1; left < root; left++) {
//            ltree.addAll(getTree(left, floor, root - 1));
//        }
//        
//        if (root + 1 <= ceiling) rtree.addAll(getTree(root + 1, root + 2, ceiling));
//        for (int right = root + 2; right <= ceiling; right ++) {
//            rtree.addAll(getTree(right, root + 1, ceiling));
//        }
//        
//        if (ltree.isEmpty()) ltree.add(null);
//        if (rtree.isEmpty()) rtree.add(null);
//        
//        for (TreeNode lt: ltree) {
//            for (TreeNode rt: rtree) {
//                TreeNode node = new TreeNode(root);
//                node.left = lt;
//                node.right = rt;
//                trees.add(node);
//            }
//        }
//        
//        return trees;
//        
//    }
    
    public static void main(String[] args) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        for (TreeNode n: res) {
            System.out.println(n);
        }
    }

}
