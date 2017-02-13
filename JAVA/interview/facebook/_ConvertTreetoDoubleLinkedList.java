package facebook;

import java.util.Stack;

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class _ConvertTreetoDoubleLinkedList {
    
    public TreeNode solve(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode head = null;
        TreeNode pre = null;
        
        while (root != null || !stack.isEmpty()) {
            
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (head == null) head = root;
            if (pre != null) {
                root.left = pre;
                pre.right = root; 
            }
            pre = root;
            root = root.right;
            
        }
        
        head.left = head.right;
        pre.right = pre.left;
        
        return head;
    }
    
    
    
    TreeNode head = null;
    TreeNode pre = null;
            
    public void helper(TreeNode root) {
        if (root == null) return;
  
        helper(root.left);
        if (head == null) head = root;
        if (pre != null) {
            root.left = pre;
            pre.right = root;
        }
        pre = root;
        helper(root.right);
        
        
        
        
    }
    
//    
//    1
//  2   3
//4  5    6    
//    
//
//head -> 4
//pre -> 4 r 2 l 2
//
//cur -> 2  l 4  r 5
//pre -> 2  
//
//cur - > 5 l 2 r 1
//pre - > 5
//
//cur -> 1 l 5 r 3
//pre -> 1
//
//cur -> 3 l 1 r 6
//pre -> 3
//
//cur -> 6 l 3 r 3
//pre -> 6
//
//
//4 2 5 1 3 6



}
