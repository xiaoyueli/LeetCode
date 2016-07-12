package math;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * 如果n是power of two，则n 二进制表示只有一个1，
 * 而  n-1 的二进制表示为其低位全为1
 * &运算的结果为0
 * & 都为  1，结果为1
 * | 至少有一个 1 ，结果为1
 * ^ 有且仅有一个1 ，结果为1
 * 
 */

public class _231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}