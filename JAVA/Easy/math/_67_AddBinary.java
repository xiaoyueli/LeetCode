package math;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *
 */
public class _67_AddBinary {
    
    public String addBinary(String a, String b) {
        
        if(a.length() > b.length()) return addBinary(b, a);
        
        StringBuilder sb = new StringBuilder();
        
        int i = a.length() - 1;
        int gap = b.length() - a.length();
        int carry = 0;
        
        while (i >= 0) {
            int sum = a.charAt(i) - '0' + (b.charAt(gap + i) - '0') + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i--;
        }
        
        i = gap - 1;
        
        while (i >= 0) {
            int sum = b.charAt(i--) - '0' + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        
        if (carry == 1) sb.insert(0, 1);
        
        return sb.toString();
        
    }
}
