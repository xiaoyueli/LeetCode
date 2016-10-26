package bitManipulation;

/**
 * 
 * @author xiaoyue
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 * 
 * 思路：
 * 4的power的二进制表示为首位为1其他位都为0，且首位是在奇数位上，即有偶数个0，例如4： 100， 16， 10000
 * 因此判断条件：
 * 1, n & (n - 1) == 0
 * 2, n & 0x55555555 == 1   // 判断1是否在奇数位上，0x55555555 的二进制表示是0101 0101 0101 ...
 *
 */

public class _342_PowerofFour {
    
    public boolean isPowerOfFour(int num) {
        
        if ((num & (num - 1)) != 0) return false;
        if ((num & 0x55555555) == 0) return false;
        
        return true;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        System.out.println(4 & 3);

    }

}
