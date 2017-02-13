package bitManipulation;

/**
 * 
 * @author xiaoyue
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given two integers x and y, calculate the Hamming distance.
    
    Note:
    0 ≤ x, y < 231.
    
    Example:
    
    Input: x = 1, y = 4
    
    Output: 2
    
    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑
    
    The above arrows point to positions where the corresponding bits are different.
 *
 */

public class _461_HammingDistance {
    
    public int hammingDistance(int x, int y) {
        
        int res = 0;
        int val = x ^ y;
        for (int i = 0; i < 32; i++) {
            if ((val & 1) == 1) res++;
            val >>= 1;
        }
        
        return res;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
