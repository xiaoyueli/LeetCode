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
        
        char[] str1 = num1.toCharArray();
        char[] str2 = num2.toCharArray();
        
        char[] res = new  char[str1.length + str2.length + 1];
        
        for (int idx = 0; idx < res.length; idx++) res[idx] = '0';
        
        int add = 0;
        int idx = res.length - 1;
        int curidx = idx;
        for (int idx1 = str1.length - 1; idx1 >= 0; idx1--) {   
            
            add = 0;
            for (int idx2 = str2.length - 1; idx2 >=0; idx2--) {
                int val1 = str1[idx1] - '0';
                int val2 = str2[idx2] - '0';
                int val = res[curidx] - '0';
                int newval = (val1 * val2 + add + val) % 10;
                add = (val1 * val2 + add + val) / 10;
                res[curidx] = (char)(newval + '0');
                curidx--;
            }
            res[curidx] = (char)(res[curidx] + add);
            curidx = --idx;
        }
        
        int sta = res.length - 1;
        for (int i = 0; i < res.length; i++) {
            if (res[i] != '0') {
                sta = i;
                break;
            }
        }
        
        String s = new String(res);
        return s.substring(sta);
    }
    

    
    public static void main(String[] args) {
        _43_MultiplyStrings test = new _43_MultiplyStrings();
        test.multiply("123456789", "987654321");
    }
}
