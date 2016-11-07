package dynamicProgramming;

/**
 * 
 * @author xiaoyue
 * 
 * A sequence of number is called arithmetic if it consists of at least three elements and 
 * if the difference between any two consecutive elements is the same.
 * 
 * For example, these are arithmetic sequence:
 * 
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * 
 * 1, 1, 2, 5, 7
 * 
 * A zero-indexed array A consisting of N numbers is given. 
 * A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * 
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * 
 * The function should return the number of arithmetic slices in the array A.
 * 
 * Example:
 * 
 * A = [1, 2, 3, 4]
 * 
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * 
 * 思路：
 * 法1.math. O(n), 求出每一段最长的 arithmetic seq. 其中的长度大于3的sub seq都是arithmetic seq. 其值为等差数列的和
 * 
 * 法2.DP。 用boolean数组标记每一个长度是否是arithmetic seq, 更新下一个长度的时候检查前一个长度是否为true并且新加入的数构成的差值是否同前
 *
 */

public class _413_ArithmeticSlices {
    
    // math
    public int numberOfArithmeticSlices(int[] A) {
        
        int length = A.length;
        if (length < 3) return 0;
        
        int res = 0;
        int len = 2;
        int diff = A[1] - A[0];
        
        for (int idx = 2 ; idx < length; idx++) {
            if (A[idx] - A[idx - 1] == diff) len++;
            else {
                if (len >= 3) res += compute(len);
                len = 2;
                diff = A[idx] - A[idx - 1];
            }

        }
        
        res += compute(len);
        
        return res;
    }
    
    private int compute(int num) {
        if (num == 3) return 1;
        
        return (num - 3 + 1) * (num - 3 + 1 + 1) / 2;
    }
    
    
    // dp
    public int numberOfArithmeticSlices2(int[] A) {
        
        int length = A.length;
        boolean[][] isAs = new boolean[length + 1][length];
        int res = 0;
        
        for (int idx = 2; idx < length; idx++) {
            if (A[idx] - A[idx - 1] == A[idx - 1] - A[idx - 2]) {
                isAs[3][idx] = true;
                res++;
            }
        }
        
        for (int len = 4; len <= length; len++) {
            
            for (int pos = len - 1; pos < length; pos++) {
                if (isAs[len - 1][pos - 1] && (A[pos] - A[pos - 1] == A[pos - 1] - A[pos - 2])) {
                    isAs[len][pos] = true;
                    res++;
                }
            }
        }
        
        return res;
    }

}
