package hashtable;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 *  return the fraction in string format.
 *  
 *  If the fractional part is repeating, enclose the repeating part in parentheses.
 *  
 *  For example,
 *  Given numerator = 1, denominator = 2, return "0.5".
 *  Given numerator = 2, denominator = 1, return "2".
 *  Given numerator = 2, denominator = 3, return "0.(6)".
 *  
 *  建一个hash表， 余数做KEY， 余数出现的位子做值， 注意细节处理
 *  建stringBuffer 循环加入每一次的商
 *  
 *  每一次余数不为零时，末尾补0， 成为新的被除数
 *
 */

public class _166_FractiontoRecurringDecimal {
    
    public String fractionToDecimal(int numerator, int denominator) {
        
        long num = numerator;
        long den = denominator;
        if (den == 0) return "";
        
        boolean isPos = true;
        if (num * den < 0) isPos = false;
        if (num < 0) num = -num;
        if (den < 0) den = -den;
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuffer sb = new StringBuffer();
       
        String fir = num / den + "";
        num = num % den;
        if (!isPos) fir = "-" + fir;
        if (num == 0) return fir;
        sb.append(fir + ".");
        int idx = sb.length();
        map.put(num, idx);
        num *= 10;
        
        do {
            sb.append(num / den + "");
            num = num % den;
            if (map.containsKey(num)) {
                int i = map.get(num);
                sb.insert(i, "(");
                sb.append(")");
                break;
            }
            idx = sb.length();
            map.put(num, idx);
            num *= 10;
        }while (num != 0); 
        
        return sb.toString();
        
    }
}
