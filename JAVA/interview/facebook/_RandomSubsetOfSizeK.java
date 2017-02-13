package facebook;

import java.util.Random;

/**
 * 
 * @author xiaoyue
 * 
 * we are given a big array (or stream) of numbers, 
 * and we need to write an efficient function to randomly select k numbers where 1 <= k <= n. 
 * 
 * http://www.geeksforgeeks.org/reservoir-sampling/
 * 
 * solution:
 * the main idea is, each number has exactly one chance to be selected.
 * that is when i increases to the bound.
 * the condition to be selected is the scaled index smaller than k. 
 * So we replace the result array;
 * 
 * the initialized numbers also have the same posibility with other nums.
 * because if they stay to the end. that means other numbers do not get they own 1 piece of chance
 *
 */

public class _RandomSubsetOfSizeK {
    
    public int[] solve(int[] nums, int n, int k) {
        
        int[] res = new int[k];
        
        int i = 0;
        for (; i < k; i++) {
            res[i] = nums[i];
        }
        i++;
        Random rand = new Random();
        for (; i <= n; i++) {
            int idx = rand.nextInt(i);
            if (idx < k) res[idx] = nums[i - 1];
        }
        
        return res;
    }

}
