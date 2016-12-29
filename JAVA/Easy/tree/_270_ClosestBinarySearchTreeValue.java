package tree;

/**
 * 
 * @author xiaoyue
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

    Note:
    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.
 */

public class _270_ClosestBinarySearchTreeValue {
    
    public int closestValue(TreeNode root, double target) {
        
        int res = root.val;
        double minDif = Double.MAX_VALUE;
        
        while (root != null) {
            if(target > root.val) {
                if (target - root.val < minDif) {
                    minDif = target - root.val;
                    res = root.val;
                }
                root = root.right;
            }
            else {
                if (root.val - target < minDif) {
                    minDif = root.val - target;
                    res = root.val;
                }
                root = root.left;
            }
        }
        
        return res;
        
    }

}
