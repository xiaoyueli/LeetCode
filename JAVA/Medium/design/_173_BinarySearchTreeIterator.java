package design;

import java.util.Stack;

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

    private Stack<TreeNode> stack;
    private TreeNode root;
    public _173_BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        this.root = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        root = stack.pop();
        int res = root.val;
        root = root.right;
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
