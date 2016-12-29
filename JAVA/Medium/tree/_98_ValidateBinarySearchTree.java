package tree;
/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Example 1:
 *  2
   / \
  1   3
   Binary tree [2,1,3], return true.
   Example 2:
     1
    / \
   2   3
 * Binary tree [1,2,3], return false.
 * 
 * 思路一，递归，每次传入当前节点的可取值范围
 * 
 * 思路二，迭代，先序遍历取得升序序列后，比较前后值得大小判断
 */


public class _98_ValidateBinarySearchTree {
    
    public boolean isValidBST(TreeNode root) {
            
        if (root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode td, long min, long max) {
        if (td == null) return true;
        if (td.val <= min || td.val >= max) return false;
        
        return helper(td.left, min, td.val) && helper(td.right, td.val, max);
    }
    
    
    
    
//   迭代     
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        Queue<Integer> que = new LinkedList<Integer>();
//        
//        while (root != null || !stack.isEmpty()) {
//            
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            
//            root = stack.pop();
//            que.offer(root.val);
//            root = root.right;
//        }
//        
//        int val = que.poll();
//        while (!que.isEmpty()) {
//            if (val >= que.peek()) return false;
//            val = que.poll();
//        }
//        
//        return true;
//    }

}
