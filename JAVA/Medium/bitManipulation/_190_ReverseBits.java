package bitManipulation;


/**
 * 
 * @author xiaoyue
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Related problem: Reverse Integer
 * 
 * 思路：
 * 左右原来的数的同时，右移answer
 *
 */

public class _190_ReverseBits {
    
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int res = 0;
        
        for (int idx = 0; idx < 32; idx++) {
            res <<= 1;
            res += (n & 1);
            n >>= 1;
        }
        

        return res;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        System.out.println(Integer.parseInt("101", 2));

    }

}
