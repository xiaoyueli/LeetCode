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
        
        int[] res = robHelper(root);
        
        return Math.max(res[0], res[1]);
    }
    
    private int[] robHelper(TreeNode td) {
        if (td == null) return new int[]{0, 0};
        if (td.left == null && td.right == null) return new int[]{td.val, 0};
        
        int[] left = robHelper(td.left);
        int[] right = robHelper(td.right);
        
        int money = td.val;
        int rob = left[1] + money + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{rob, notRob};
        
    }

}
