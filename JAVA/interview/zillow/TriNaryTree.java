package zillow;

/**
 * 
 * @author xiaoyue
 * 
 * Implement insert and delete in a tri-nary tree. 
 * A tri-nary tree is much like a binary tree but with three child nodes for each parent instead of two -- 
 * with the left node being values less than the parent, the right node values greater than the parent, 
 * and the middle nodes values equal to the parent.
 *
 * For example, suppose I added the following nodes to the tree in this order: 5, 4, 9, 5, 7, 2, 2.
 * The resulting tree would look like this:
        5
      / | \
    4  5  9
    /     /
    2   7. 
    |
    2
 */

/* PLEASE DO NOT UNCOMMENT THIS BLOCK

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
// No other imports are permitted

// The following definitions of Tree and Node are provided.
// insert and delete will be methods of class Tree.
*/

public class TriNaryTree {
    private class Node {
        private int val;
        private Node left = null;
        private Node right = null;
        private Node mid = null;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;


    /*
     * Please complete this method.
     * Inserts val into the tree.
     */
    public void insert(int val) {
        
        if (root == null) root = new Node(val);
        else insert(root, val);
        
    }

    private void insert(Node root, int val) {
        
        if (val < root.val && root.left == null) {
            root.left = new Node(val);
            return;
        }
        else if (val < root.val) insert(root.left, val);
        else if (val > root.val && root.right == null) {
            root.right = new Node(val);
            return;
        }
        else if (val > root.val) insert(root.right, val);
        else if (val == root.val && root.mid == null) {
            root.mid = new Node(val);
            return;
        }
        else insert(root.mid, val);

    }

    /*
     * Please complete this method.
     * Deletes only one instance of val from the tree.
     * If val does not exist in the tree, do nothing.
     */
    public void delete(int val) {
        
       root = delete(root, val);

    }

    private Node delete(Node root, int val) {
        
        if (root == null) return null;
        
        if (root.val == val && root.mid != null) root.mid = delete(root.mid, val);
        else if (root.val == val) {
            Node rightMin = findRightMin(root.right);
            if (rightMin == null) return root.left;
            rightMin.left = root.left;
            return root.right;
        }
        else if (val > root.val) root.right = delete(root.right, val);
        else root.left = delete(root.left, val);
        
        return root;
    }
    
    private Node findRightMin(Node node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
//    private void print() {
//        
//        Queue<Node> que = new LinkedList<Node>();
//        que.offer(root);
//        int size = 1;
//        while (!que.isEmpty()) {
//            Node cur = que.poll();
//            size--;
//            System.out.print(cur.val + " ");
//            if (cur.left != null) que.offer(cur.left);
//            if (cur.mid != null) que.offer(cur.mid);
//            if (cur.right != null) que.offer(cur.right);
//            if (size == 0) {
//                System.out.println();
//                size = que.size();
//            }
//        }
//    }
//    
    public static void main(String[] args) {
//        TriNaryTree test = new TriNaryTree();
//        test.insert(8);
//        test.insert(5);
//        test.insert(8);
//        test.insert(9);
//        test.insert(6);
//        test.insert(3);
//        test.insert(5);
//        test.insert(1);
//        test.insert(3);
//        test.insert(4);
//        test.print();
//        System.out.println();
//        test.delete(5);
//        test.print();
//        System.out.println();
//        test.delete(5);
//        test.print();
        
        System.out.println(-7 % 5);
             
    }
}
