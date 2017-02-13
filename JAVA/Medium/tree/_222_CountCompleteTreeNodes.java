package tree;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *  
 *  计算完全二叉树，
 *  思路，如果是满二叉树就返回
 *  否则求左右子树是否是满二叉树
 *  
 *  用Math.pow超时
 */



public class _222_CountCompleteTreeNodes {
    
    public int countNodes(TreeNode root) {
        
        int sum = 0;
        int height = 0;
        
        while (root != null) {
            
            if (height == 0) height = getLeftHeight(root);
            int subhr = getRightHeight(root.left);
            if (height == subhr + 1) {
                sum += 1 << subhr;
                root = root.right;
                height = 0;   // 如果左子数是满二叉树，需重新计算树高
            }
            else {
                sum += 1 << subhr;
                root = root.left;
                height--;
            }
        }
        
        return sum;
        
    }
    
    private int getLeftHeight(TreeNode root) {
        int height = 0;    
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }
    
    private int getRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.right;
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        System.out.println(  3<< 1 );

    }

}
