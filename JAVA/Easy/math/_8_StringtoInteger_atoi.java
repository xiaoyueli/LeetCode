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
        
        if (str.length() == 0) return 0;
        char[] arr = str.toCharArray();
        
        int begin = 0;
        for (int idx = 0; idx < arr.length; idx++) {
            char c = arr[idx];
            if (c == ' ') continue;
            if (isInteger(c) || isSign(c)) {
                begin = idx;
                break;
            }
            else return 0;
        }
        
        int end = begin;
        for (int idx = begin + 1; idx < arr.length; idx++) {
            char c = arr[idx];
            if (isInteger(c)) end++;
            else break;
        }
        
        int val = atoi(arr, begin, end);
        
        return val;
        
    }
    
    public int atoi(char[] arr, int begin, int end) {
        
        boolean flag = true;
        char c = arr[begin];
        
        long val = 0;
        if (!isSign(c)) val = c - '0';
        if (c == '-') flag = false;
        
        for (int idx = begin + 1; idx <= end; idx++) {
            if (flag) {
                val = val * 10 + (arr[idx] - '0');
                if (val >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            else{
                val = val * 10 - (arr[idx] - '0');
                if (val <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
            
        }
        
        return (int)val;
    }
    
    public boolean isInteger(char c) {
        int val = c - '0';
        if (val >= 0 && val <= 9) return true;
        return false;
    }
    
    public boolean isSign(char c) {
        if (c == '-' || c == '+') return true;
        return false;
    }
}
