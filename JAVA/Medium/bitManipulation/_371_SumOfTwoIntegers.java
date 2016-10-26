package bitManipulation;

/**
 * 
 * @author xiaoyue
 * 
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * 
 * Example:
 * Given a = 1 and b = 2, return 3.
 * 
 * 思路：
 * 用 异或 求和
 * 用 与 左移一位求进位
 *
 */

public class _371_SumOfTwoIntegers {
    
    public int getSum(int a, int b) {
        

        int digit = a ^ b;
        int carry = (a & b) << 1;
        
        while ((digit & carry) != 0) {
            int temp = digit ^ carry;
            carry = (digit & carry) << 1;
            digit = temp;
        }
             
        
        return carry ^ digit;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
