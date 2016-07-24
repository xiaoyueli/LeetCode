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
        
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        
        String res;
        
        if (ca.length > cb.length) res = compute(ca, cb);
        else res = compute(cb, ca);
        
        return res;
    }
    
    public String compute(char[] a, char[] b) {
        
        int idxb = b.length - 1;
        int idxa = a.length - 1;
        int sum = 0;
        while (idxb >= 0) {
            int vala = a[idxa] - '0';
            int valb = b[idxb--] - '0';
            int val = (sum + vala + valb) % 2;
            sum = (sum + vala + valb) / 2;
            a[idxa--] = (char)(val + '0');
        }
        
        while (idxa >= 0) {
            int vala = a[idxa] - '0';
            int val = (sum + vala) % 2;
            sum = (sum + vala) / 2;
            a[idxa--] = (char)(val + '0');
        }
        
        String res = new String(a);
        if (sum > 0) res = sum + res;
        return res;
    }
}
