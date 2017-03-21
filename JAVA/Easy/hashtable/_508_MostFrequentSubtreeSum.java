package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree sum. 
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). 
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

    Examples 1
    Input:
    
      5
     /  \
    2   -3
    return [2, -3, 4], since all the values happen only once, return all of them in any order.
    Examples 2
    Input:
    
      5
     /  \
    2   -5
    return [2], since 2 happens twice, however -5 only occur once.
    Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 *
 */

public class _508_MostFrequentSubtreeSum {
    
    public int[] findFrequentTreeSum(TreeNode root) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        helper(root, map);
        
        List<Integer> ls = new ArrayList<Integer>();
        int max = 0;
        for (int key: map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                ls = new ArrayList<Integer>();
                ls.add(key);
            }
            else if (map.get(key) == max) ls.add(key);
        }
        
        int[] res = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) res[i] = ls.get(i);
        return res;
        
    }
    
    private int helper(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return 0;
        
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        
        int val = left + right + root.val;
        if (map.containsKey(val)) map.put(val, map.get(val) + 1);
        else map.put(val, 1);
        
        return val;
    }

}
