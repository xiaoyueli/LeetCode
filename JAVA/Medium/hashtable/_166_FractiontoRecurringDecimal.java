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
 *
 */

public class _166_FractiontoRecurringDecimal {
    
    public String fractionToDecimal(int numerator, int denominator) {
        
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) sb.append("-");
        long num = numerator;
        long den = denominator;
        
        num = Math.abs(num);
        den = Math.abs(den);
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        sb.append((num / den) + "");
        num %= den;
        if (num != 0) sb.append(".");
        
        while (num != 0) {
            if (map.containsKey(num)) {
                int idx = map.get(num);
                sb.insert(idx, "(");
                sb.append(")");
                break;
            }
            
            map.put(num, sb.length());
            num *= 10;
            sb.append((num / den) + "");
            num %= den;
        }
        
        return sb.toString();
        
    }
}
