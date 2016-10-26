package bitManipulation;

/**
 * 
 * @author xiaoyue
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, 
 * return the bitwise AND of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * 思路：
 * m到n这个范围的数的二进制从左到右总有相同的公共部分
 * 当把所有这些数 做与运算的时候，只有都为1的位数会保留1，其他位都会为0
 * 因此每次将m,n向右移动，然后比较它们是否相等
 * 当相等后再右移相同的位子，即为答案
 *
 */

public class _201_BitwiseANDofNumbersRange {
    
    public int rangeBitwiseAnd(int m, int n) {
        
        int offset = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        
        return m << offset;
        
    }

}
