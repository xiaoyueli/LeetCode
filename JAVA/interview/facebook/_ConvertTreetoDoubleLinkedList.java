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
    
    public Node solve(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        Node head = null;
        Node cur = null;
        
        while (!stack.isEmpty() || root != null) {
            
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (head == null) {
                head = new Node(root.val);
                cur = head;
            }
            else {
                cur.next = new Node(root.val);
                cur = cur.next;
            }
            root = root.right;
        }
        
        cur.next = head;
        return head;
    }

}
