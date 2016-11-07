package array;

/**
 * 
 * @author xiaoyue
 * 
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * 
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * 
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * 
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 */


public class _414_ThirdMaximumNumber {
    
    

    public int thirdMax(int[] nums) {
        
        Integer one = null;
        Integer two = null;
        Integer three = null;
        
        for (int i: nums) {
            if (one == null || i > one) {
                three = two;
                two = one;
                one = i;
            }
            else if (two == null || i > two) {
                if (i == one) continue;
                three = two;
                two = i;
            }
            else if (three == null || i > three) {
                if (i == two) continue;
                three = i;
            }
        }
        
        if (three == null) return one;
        return three;

    }

}
