package math;

/**
 * Given two numbers represented as strings, 
 * return multiplication of the numbers as a string.
 * 
 * Note:
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 *
 */

public class _43_MultiplyStrings {
    
    public String multiply(String num1, String num2) {
        
        int length = num1.length() + num2.length();
        int[] res = new int[length];
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            int pos = length-- - 1;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry + res[pos];
                res[pos--] = val % 10;
                carry = val / 10;
            }
            res[pos] = carry;
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int num: res) if (num != 0 || sb.length() != 0) sb.append(num);
        
        return sb.length() == 0 ? "0" : sb.toString();
   
    }
    

    
    public static void main(String[] args) {
        _43_MultiplyStrings test = new _43_MultiplyStrings();
        test.multiply("123456789", "987654321");
    }
}
