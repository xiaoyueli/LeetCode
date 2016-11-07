package math;

/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, 
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 *
 *  处理溢出，遍历字符串，使用长整型，每一次乘10
 */

public class _8_StringtoInteger_atoi {
    
    public int myAtoi(String str) {
        
        str = str.trim();
        
        char[] seq = str.toCharArray();
        
        int length = seq.length;
        if (length == 0) return 0;

        int sta = 0;
        boolean isNeg = false;
        if (seq[0] == '-') {
            isNeg = true;
            sta = 1;
        }
        else if (seq[0] == '+') sta = 1;
        
        long res = 0;
        while (sta < length && seq[sta] >= '0' && seq[sta] <= '9') {
            
            if (isNeg) {
                res = res * 10 - (seq[sta] - '0');
                if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
            else {
                res = res * 10 + (seq[sta] - '0');
                if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            sta++;
        }

        return (int) res;
    }
}
