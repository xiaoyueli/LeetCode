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
    
    // 迭代
    public int countNodes(TreeNode root) {
        
        int sum = 0;
        int height = 0;
        
        boolean flag = true;
        while (root != null) {
            
            TreeNode temp = root;
            if (flag) {
                height = 0;
                //计算数高
                while (temp != null) {
                    temp = temp.left;
                    height++;
                }
            }

            temp = root.left;
            int subH = 0;
            // 验证左子树是否是满二叉树
            while (temp != null) {
                temp = temp.right;
                subH++;
            }
            
            if (subH + 1 == height) {
                // 若左子树是满二叉树，累计左子树的Node数
                // 将root更新为右子树
                sum += 1 << subH;
                root = root.right;
                flag = true;  // 需要重新计算新的数高
            }
            else {
                // 否则右子树是满二叉树，累计右子树Node数
                // 将root 更新为左子树
                sum += 1 << (height - 2);
                root = root.left;
                height--; // 更新新的树高，不需要重新计算 
                flag = false;
            }
        }
        
        return sum;

    }
    
    // 递归
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        
        TreeNode temp = root;
        int llevel = 0;
        while (temp != null) {
            temp = temp.left;
            llevel++;
        }
        
        temp = root;
        int rlevel = 0;
        while (temp != null) {
            temp = temp.right;
            rlevel++;
        }
        
        if (llevel == rlevel) return (1 << llevel) - 1;
        
        int res = countNodes(root.left) + countNodes(root.right) + 1;
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        System.out.println(  3<< 1 );

    }

}
