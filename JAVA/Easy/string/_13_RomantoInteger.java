package string;

/**
 * 罗马数字规则
 * 从右往左
 * 左边的数大于等于当前数字就加上，小于就减去
 */

public class _13_RomantoInteger {
    
    public int romanToInt(String s) {
        
        char[] seq = s.toCharArray();
        int len = seq.length;
        
        int sum = getNum(seq[len - 1]);
        for (int idx = len - 2; idx >= 0; idx--) {
            int pre = getNum(seq[idx + 1]);
            int cur = getNum(seq[idx]);
            if (cur >= pre) sum += cur;
            else sum -= cur;
        }     
        return sum;
    }
    
    private int getNum(char c) {
        
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100; 
            case 'D' : return 500;
            case 'M' :  return 1000;
        }
        return 0;
    }
}
