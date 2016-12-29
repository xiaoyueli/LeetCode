package tree;

/**
 * 
 * @author xiaoyue
 * 
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, 
 * but it must go downwards (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * 
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

          10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1
    
    Return 3. The paths that sum to 8 are:
    
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
 * 思路：
 * 1. dfs root, 然后+dfs左右子数的和
 * 整个问题将一个大树分解成左右小树的问题
 * 
 * 
 * 2 .从leaf 从下自上累计和，
 * 每一层 在下一层的和的基础上加上当前node的value, 及单独的node.val，然后累计计算此刻有多少值==sum,
 *
 */

public class _437_PathSum3 {
    
    
    public int pathSum(TreeNode root, int sum) {
        
        if (root == null) return 0;
        return helper(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int helper(TreeNode root, int val, int sum) {
        
        if (root == null) return 0;
        
        int res = 0;
        if (val + root.val == sum) res++;
        
        res += helper(root.left,  val + root.val, sum);
        res += helper(root.right, val + root.val, sum);
        
        return res;
    }
    
    
//    int cnt;
//    public int pathSum(TreeNode root, int sum) {
//        
//        helper(root, sum);
//        
//        return cnt;
//    }
//    
//    private List<Integer> helper(TreeNode root, int sum) {
//        
//        if (root == null) return null;
//        
//        List<Integer> res = new ArrayList<Integer>();
//        res.add(root.val);
//        List<Integer> left = helper(root.left, sum);
//        List<Integer> right = helper(root.right, sum);
//        
//        
//        addAll(res, left, root.val);
//        addAll(res, right, root.val);
//        
//        for (int num: res) if (num == sum) cnt++;
//        
//        return res;
//
//    }
//    
//    private void addAll(List<Integer> res, List<Integer> ls, int val) {
//        if (ls == null) return;
//        
//        for (int num: ls) {
//            res.add(val + num);
//        }
//    }

}
