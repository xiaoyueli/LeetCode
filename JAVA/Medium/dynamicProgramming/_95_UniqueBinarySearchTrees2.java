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
    
    
    // dp
    public List<TreeNode> generateTrees1(int n) {
        
        if (n == 0) return new ArrayList<TreeNode>();
        
        List<TreeNode>[] dp = new List[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = new ArrayList<TreeNode>();
        dp[0].add(null);
        
        for (int num = 1; num <= n; num++) {
            for (int root = 1; root <= num; root++) {
                List<TreeNode> lsons = dp[root - 1];
                List<TreeNode> rsons = dp[num - root];
                
                for (TreeNode ls: lsons) {
                    for (TreeNode rs: rsons) {
                        TreeNode rNode = new TreeNode(root);
                        rNode.left = ls;
                        rNode.right = clone(rs, root); // 右边的val都比左边的大root的值
                        dp[num].add(rNode);
                    }
                }
            }
        }
        
        return dp[n];
        
    }
    
    private TreeNode clone(TreeNode node, int offset) {
        
        if (node == null) return null;
        
        TreeNode copy = new TreeNode(node.val + offset);
        copy.left = clone(node.left, offset);
        copy.right = clone(node.right, offset);
        
        return copy;
    }
    
    public static void main(String[] args) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        for (TreeNode n: res) {
            System.out.println(n);
        }
    }

}
