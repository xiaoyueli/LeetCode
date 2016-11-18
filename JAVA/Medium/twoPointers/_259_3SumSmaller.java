package twoPointers;

import java.util.Arrays;

/**
 * 
 * @author xiaoyue
 * 
 * Given an array of n integers nums and a target, 
 * find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * 
 * Return 2. Because there are two triplets which sums are less than 2:
 * 
 * [-2, 0, 1]
 * [-2, 0, 3]
 * 
 * Follow up:
 * Could you solve it in O(n2) runtime?
 * 
 * 思路同3sum， 任然用两边逼近的办法，
 * 只是当满足条件的时候， three 和 two之间的数都能构成符合条件的组合，因此应该加上 three - two
 *
 */

public class _259_3SumSmaller {
    

    public int threeSumSmaller(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int len = nums.length;
        if (len < 3) return 0;
        
        int res = 0;
        
        for (int one = 0; one < len - 2; one++) {
            int two = one + 1;
            int three = len - 1;
            
            while (two < three) {
                int sum = nums[one] + nums[two] + nums[three];
                
                if (sum < target) {
                    res += three - two;  // two - three 之间的数构成的组合都小于target
                    two++;
                }
                else three--;
            }

        }
        
        return res;
    }

}
