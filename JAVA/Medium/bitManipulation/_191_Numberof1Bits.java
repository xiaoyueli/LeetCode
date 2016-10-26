package bitManipulation;

/**
 * 
 * @author xiaoyue
 * 
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has 
 * (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
 * so the function should return 3.
 *
 */

public class _191_Numberof1Bits {
    
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int cnt = 0;
        
        for (int idx = 0; idx < 32; idx++) {
            if ((n & 1) == 1) cnt++;
            n >>= 1;
        }
        
        return cnt;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
