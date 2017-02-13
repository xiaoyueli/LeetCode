package array;

/**
 * 
 * @author xiaoyue
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
   The digits are stored such that the most significant digit is at the head of the list.
 */

public class _66_PlusOne {
    
    public int[] plusOne(int[] digits) {
        
        if (digits[0] == 0) {
            digits[0] = 1;
            return digits;
        }
        
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i] += 1;
                return digits;
            }
            else digits[i] = 0;
        }      

        digits = new int[digits.length + 1];
        digits[0] = 1;
     
        return digits;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
