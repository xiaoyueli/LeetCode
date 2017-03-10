package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author xiaoyue
 * 
 * Given a circular array (the next element of the last element is the first element of the array), 
 * print the Next Greater Number for every element. 
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, 
 * which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

    Example 1:
    Input: [1,2,1]
    Output: [2,-1,2]
    Explanation: The first 1's next greater number is 2; 
    The number 2 can't find next greater number; 
    The second 1's next greater number needs to search circularly, which is also 2.
    Note: The length of given array won't exceed 10000.
 *
 */

public class _503_NextGreaterElement_2 {
    
    public int[] nextGreaterElements(int[] nums) {
        
        
        Stack<Integer> stack = new Stack<Integer>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        
        for (int i = 0; i < len * 2; i++) {
            int num = nums[i % len];
            while (!stack.isEmpty() && nums[stack.peek()] < num) res[stack.pop()] = num;
            if (i < len) stack.push(i);
        }
        
        
        return res;
    }

}
