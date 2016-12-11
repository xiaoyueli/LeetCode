package zillow;

import java.util.Stack;

public class Interview {
    
 // Given an array 0 to n-1, sorted, find a missing integer


    public int solve(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid == nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        
        return nums[left] - 1;
    }


//    0 1 2 3 5
//    1 2 3 4 5
//
//    2 3  1
//    0 1  -1
//
//    0

    // Given a binary search tree, print its values into a string. 

    /*
        10
       / \
      7   15
     / \  / \
    5  8  13 16
    */

    class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public void inOrderTravel(Node root) {
        if (root == null) return;
        
        Stack<Node> stack = new Stack<Node>();

        
        while (!stack.isEmpty() || root != null) {
            
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            Node cur = stack.pop();
            
            System.out.println(cur.val);
            root = cur.right;
        }
        
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
