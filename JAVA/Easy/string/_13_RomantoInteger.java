package string;

/**
 * 罗马数字规则
 * 从右往左
 * 左边的数大于等于当前数字就加上，小于就减去
 */

public class _13_RomantoInteger {
    
    public int romanToInt(String s) {

        int len = s.length();
        int res = getNum(s, len - 1);
        
        for (int idx = len - 2; idx >= 0; idx--) {
            if (getNum(s, idx + 1) <= getNum(s, idx)) res += getNum(s, idx);
            else res -= getNum(s, idx);
        }
        return res;
    }
    
    public int getNum(String str, int idx) {
        char c = str.charAt(idx);
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
