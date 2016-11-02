package dynamicProgramming;

/**
 * The thief has found himself a new place for his thievery again. 
 * There is only one entrance to this area, called the "root." 
 * Besides the root, each house has one and only one parent house. 
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * 
 * Example 1:     
 *   3
    / \
   2   3
    \   \ 
     3   1
 * 
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *    3
     / \
    4   5
   / \   \ 
  1   3   1
  
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * @author xiaoyue
 * 
 * 思路：
 * track two status of each subtree;
 * update the status of current node based on the status of each subtree
 *
 */

public class _337_HouseRobber3 {
	
    public int rob(TreeNode root) {
        
        if (root == null) return 0;
        
        int[] profit = helper(root);
        
        return Math.max(profit[0], profit[1]);
        
    }
    
    private int[] helper(TreeNode td) {
        
        int[] res = new int[]{0, 0};
        if (td == null) return res;
        
        int[] left = helper(td.left);
        int[] right = helper(td.right);

        
        res[0] = left[1] + right[1] + td.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return res;
    }

}
