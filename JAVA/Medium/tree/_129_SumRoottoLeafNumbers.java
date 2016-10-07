package tree;

/**
 * Given a binary tree containing digits from 0-9 only, 
 * each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 *   1
    / \
   2   3
 *  
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 */

public class _129_SumRoottoLeafNumbers {
    
    public int sumNumbers(TreeNode root) {

        if (root == null) return 0;
        
        return helper(root, 0, 0);
        
    }
    
    public int helper(TreeNode td, int sum, int total) {
        int curSum = sum * 10 + td.val;
        if (td.left == null && td.right == null) {
            total += curSum;
            return total;
        }
        
        if (td.left == null) return helper(td.right, curSum, total);
        if (td.right == null) return helper(td.left, curSum, total);
        
        int lsum = helper(td.left, curSum, total);
        int rsum = helper(td.right, curSum, total);
        
        return lsum + rsum;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
