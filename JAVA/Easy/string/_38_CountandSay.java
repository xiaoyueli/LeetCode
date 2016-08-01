package string;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * #
 *
 */

public class _38_CountandSay {
    
    public String countAndSay(int n) {
        
        if (n == 1) return "1";
        
        String s = "1";
        int count = 1;
        
        while (count < n) {
            char[] seq = s.toCharArray();
            int cnt = 1;
            char last = seq[0];
            StringBuilder sb = new StringBuilder();
            for (int idx = 1; idx < seq.length; idx++) {
                char c = seq[idx];
                if (c == last) cnt++;
                else {
                    sb.append(cnt + "" + last);
                    cnt = 1;
                    last = c;
                }
            }
            sb.append(cnt + "" + last);
            s = sb.toString();
            count++;
        }
        
        return s;
    }
    
    public static void main(String[] args) {
        _38_CountandSay test = new _38_CountandSay();
        test.countAndSay(2);
    }

}
