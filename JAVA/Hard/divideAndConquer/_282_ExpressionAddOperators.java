package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * 
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

    Examples: 
    "123", 6 -> ["1+2+3", "1*2*3"] 
    "232", 8 -> ["2*3+2", "2+3*2"]
    "105", 5 -> ["1*0+5","10-5"]
    "00", 0 -> ["0+0", "0-0", "0*0"]
    "3456237490", 9191 -> []
 *
 */

public class _282_ExpressionAddOperators {
    
    public List<String> addOperators(String num, int target) {
        
        List<String> res = new ArrayList<String>();
        
        
        helper(res, num, target, "", 0, 0, 0);
        
        return res;
    }
    
    private void helper(List<String> res, String str, int k, String path, int pos, long val, long lastNum) {
        
        if (pos == str.length()) {
            if (val == k) res.add(path);
            return;
        }
        
        for (int i = pos + 1; i <= str.length(); i++) {
            
            if (str.charAt(pos) == '0' && i - pos > 1) break;
            
            long num = Long.parseLong(str.substring(pos, i));
            
            if (pos == 0) {
                helper(res, str, k, num + "", i, num, num);
            }
            else {
                helper(res, str, k, path + "+" + num, i, val + num, num);
                helper(res, str, k, path + "-" + num, i, val - num, -num);
                helper(res, str, k, path + "*" + num, i, val - lastNum + lastNum * num, lastNum * num);
            }
        }
    }

}
