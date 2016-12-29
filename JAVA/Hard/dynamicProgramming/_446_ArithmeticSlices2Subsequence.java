package dynamicProgramming;

import java.util.HashMap;

/**
 * 
 * @author xiaoyue
 * 
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

    For example, these are arithmetic sequences:
    
    1, 3, 5, 7, 9
    7, 7, 7, 7
    3, -1, -5, -9
    The following sequence is not arithmetic.
    
    1, 1, 2, 5, 7
    
    A zero-indexed array A consisting of N numbers is given. 
    A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
    
    A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. 
    In particular, this means that k ≥ 2.
    
    The function should return the number of arithmetic subsequence slices in the array A.
    
    The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 231-1.
    
    
    Example:
    
    Input: [2, 4, 6, 8, 10]
    
    Output: 7
    
    Explanation:
    All arithmetic subsequence slices are:
    [2,4,6]
    [4,6,8]
    [6,8,10]
    [2,4,6,8]
    [4,6,8,10]
    [2,4,6,8,10]
    [2,6,10]
 * 
 * 
 * 思路：计算每一个点作为结束点时能形成多少有效序列， 和跳frog jump类似
 * 
 * 更新的原则：
 * 计算与前面所有点的差值。如果check点也存在这样的差值，当前点加上check点在这个diff处能形成的序列数+1
 * 
 * 因为一个序列需要至少三个数。因此实际上的更新是check点的值-1 再 + 1。
 * 
 * 
 */

public class _446_ArithmeticSlices2Subsequence {
    
    public int numberOfArithmeticSlices(int[] A) {
        
        if (A.length < 3) return 0;
        
        HashMap<Integer, Integer>[] map = new HashMap[A.length];
        int res = 0;
        
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; j++) {
                
                long dif = (long)A[i] - A[j];
                if (dif >= Integer.MAX_VALUE || dif <= Integer.MIN_VALUE) continue;
                int cnt = 0;
                int key = (int)dif;
                
                if (map[j].containsKey(key)) {  // 如果之前相差diff的数也存在diff的序列，就加上它的值
                    cnt = map[j].get(key);
                    res += cnt;         // 实际应该是cnt + 1, 但由于需要三个数形成一个sequence，实际的cnt已经多一个1
                }
                
                map[i].put(key, cnt + 1 + map[i].getOrDefault(key, 0));  // 长度为2时，值为1， 因此当需三个数形成一个sequence时，需减1
            }
        }
        
        return res;
    }

}
