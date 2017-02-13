package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author xiaoyue
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

    Note:
    Given target value is a floating point.
    You may assume k is always valid, that is: k ≤ total nodes.
    You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
    Follow up:
    Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 * 
 * 思路：
 * 1. On
 * in order travel 将所有值加入list, 找到小于target的数量，根据情况删除多余的节点
 * 
 * 
 * 2. Klog n
 * 用两个栈，分别保存大于和小于target的node. 然后根据差值pop 出最近的Node，加入list， 直到加满K个值
 * 
 */

public class _272_ClosestBinarySearchTreeValue2 {
    
    // Klogn
    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        Stack<TreeNode> pres = new Stack<TreeNode>();
        Stack<TreeNode> sucs = new Stack<TreeNode>();
        
        while (root != null) {
            if (root.val < target) {
                pres.push(root);
                root = root.right;
            }
            else {
                sucs.push(root);
                root = root.left;
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        while (k > 0) {
            if (pres.isEmpty()) res.add(getNext(sucs, false));
            else if (sucs.isEmpty()) res.add(getNext(pres, true));
            else {
                if (target - pres.peek().val < sucs.peek().val - target) res.add(getNext(pres, true));
                else res.add(getNext(sucs, false));
            }
            k--;
        }
        
        return res;
    }
    
    private int getNext(Stack<TreeNode> stack, boolean isPre) {
        TreeNode root = stack.pop();
        int res = root.val;
        if (isPre) root = root.left;
        else root = root.right;
        
        while (root != null) {
            stack.push(root);
            if (isPre) root = root.right;
            else root = root.left;
        }
        return res;
    }
    
    
    // On
    public List<Integer> closestKValues1(TreeNode root, double target, int k) {

        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        boolean isLess = true;
        int pivot = 0;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            if (isLess && stack.peek().val >target) {
                isLess = false;
                pivot = res.size(); // 小于target的数量
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        
        
        int length = res.size();
        if (isLess) pivot = res.size();
        
        int greater = length - pivot; // 大于target的数量
        if (pivot <= k / 2) {
            while (res.size() > k) res.remove(k);
            return res;
        }
        
        if (greater <= k / 2) {
            while (res.size() > k) res.remove(0);
            return res;
        }

        int pre = 0;
        while (pivot > k / 2) {
            pre = res.remove(0);
            pivot--;
        }
        while (res.size() > k) res.remove(k);
        
        if (k % 2 == 1 && target - pre < res.get(k - 1) - target) {
            res.remove(k - 1);
            res.add(0, pre);
        }
        
        return res;
  
    }

}
