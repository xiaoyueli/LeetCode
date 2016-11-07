package string;

import java.util.List;

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
        
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(1);
        int i = 1;

        while (i < n) {
            int cnt = 0;
            int cur = ls.get(0);
            List<Integer> temp = new ArrayList<Integer>();
            for (int num: ls) {
                if (num == cur) cnt++;
                else {
                    temp.add(cnt);
                    temp.add(cur);
                    cur = num;
                    cnt = 1;
                }
            }
            temp.add(cnt);
            temp.add(cur);
            ls = temp;
            i++;
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int num: ls) sb.append(num);
        
        return sb.toString();
    }
    
//    public String countAndSay(int n) {
//        
//        if (n == 1) return "1";
//        
//        String s = "1";
//        int count = 1;
//        
//        while (count < n) {
//            char[] seq = s.toCharArray();
//            int cnt = 1;
//            char last = seq[0];
//            StringBuilder sb = new StringBuilder();
//            for (int idx = 1; idx < seq.length; idx++) {
//                char c = seq[idx];
//                if (c == last) cnt++;
//                else {
//                    sb.append(cnt + "" + last);
//                    cnt = 1;
//                    last = c;
//                }
//            }
//            sb.append(cnt + "" + last);
//            s = sb.toString();
//            count++;
//        }
//        
//        return s;
//    }
    
    public static void main(String[] args) {
        _38_CountandSay test = new _38_CountandSay();
        test.countAndSay(2);
    }

}
