package design;

/**
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
 * where h is the height of the tree.
 *
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _173_BinarySearchTreeIterator {

    //method1: without stack
    TreeNode root;
    public _173_BinarySearchTreeIterator(TreeNode root) {
        this.root = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {    
        return root != null;
    }

    /** @return the next smallest number */
    public int next() {
        
        TreeNode temp = root;
        
        if (temp.left == null) {
            root = temp.right;
            return temp.val;
        }
        TreeNode pre = temp;
        while (temp != null) {
            while (temp.left != null) {
                pre = temp;
                temp = temp.left;
            }
            
            pre.left = temp.right;
            return temp.val;
        }
        
        return 0;
    }
    
    //method2: with stack
//    Stack<TreeNode> sta = new Stack<TreeNode>();
//    TreeNode root;
//    public BSTIterator(TreeNode root) {
//        this.root = root;
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return root != null || !sta.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        
//        while (root != null) {
//            sta.push(root);
//            root = root.left;
//        }
//        
//        TreeNode cur = sta.pop();
//        if (cur.right != null) root = cur.right;
//        
//        return cur.val;
//   
//    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
