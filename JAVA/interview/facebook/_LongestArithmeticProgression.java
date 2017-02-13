package facebook;

import java.util.HashMap;

/**
 * 
 * @author xiaoyue
 *
 */

public class _LongestArithmeticProgression {
    
    public int solve(int[] nums) {
        
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<Integer, Integer>();
            for (int j = i - 1; j >= 0; j--) {
                int dif = nums[i] - nums[j];

                if (!dp[j].containsKey(dif)) dp[j].put(dif, 1);
                dp[i].put(dif, dp[j].get(dif) + 1);

                if (dp[i].get(dif) > max) max = dp[i].get(dif);
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _LongestArithmeticProgression test = new _LongestArithmeticProgression();
        int[] nums = new int[]{1, 7, 10, 15, 27, 29};
        System.out.println(test.solve(nums));
    }

}
