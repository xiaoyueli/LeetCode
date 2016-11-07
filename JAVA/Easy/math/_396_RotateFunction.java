package math;

/**
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, 
 * we define a "rotation function" F on A as follow:
 * 
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * 
 * Note:
 * n is guaranteed to be less than 105.
 * 
 * Example:
 * A = [4, 3, 2, 6]
 * 
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 每一轮每个数都位移1位，等同于在上一轮sum的基础上加上自己
 * 而最后一个数由于换到了0位，归0， 就需要减掉上一轮累计的值及本轮加的自己，即n * val;
 * 公式：
 * sum = sum + digitSum - n * val of last number
 *
 */

public class _396_RotateFunction {
	
    public int maxRotateFunction(int[] A) {
        
        int len = A.length;
        int sum = 0;
        int sumOfElement = 0;
        
        for (int idx = 0; idx < len; idx++) {
            sum += idx * A[idx];
            sumOfElement += A[idx];
        }
        
        int max = sum;
        
        for (int idx = len - 1; idx > 0; idx--) {
            sum += sumOfElement - len * A[idx];
            if (sum > max) max = sum;
        }
        
        return max;
    
    }

}
