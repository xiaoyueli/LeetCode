package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author xiaoyue
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree
    
        1
       / \
      2   3
         / \
        4   5
    as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
    You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
    Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * 
 * 
 * solution:
 * 1, level travel
 * 
 */

public class _297_SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null) return "#";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        sb.append(root.val + " ");
        
        while (!que.isEmpty()) {
            
            TreeNode cur = que.poll();
            addNode(cur.left, que, sb);
            addNode(cur.right, que, sb);
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
        
    }
    
    private void addNode(TreeNode node, Queue<TreeNode> que, StringBuilder sb) {
        if (node == null) sb.append("#" + " ");
        else {
            sb.append(node.val + " ");
            que.offer(node);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] seq = data.split(" ");
        if (seq[0].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(seq[0]));
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int idx = 1;
        while (idx < seq.length) {
            TreeNode cur = que.poll();
            cur.left = convert(seq, idx++);
            if (cur.left != null) que.offer(cur.left);
            cur.right = convert(seq, idx++);
            if (cur.right != null) que.offer(cur.right);
        }
        
        return root;
        
    }
    
    private TreeNode convert(String[] seq, int idx) {
        if (idx == seq.length) return null;
        if (seq[idx].equals("#")) return null;
        return new TreeNode(Integer.parseInt(seq[idx]));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
