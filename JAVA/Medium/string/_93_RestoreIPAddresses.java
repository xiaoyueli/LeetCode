package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, 
 * restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * IP地址规则：每一组数字在0 - 255之间
 * 回溯法
 */

public class _93_RestoreIPAddresses {
    
    public List<String> restoreIpAddresses(String s) {
        
        List<String> res = new ArrayList<String>();
        
        helper(res, s, 0, 0, "");
        
        return res;
    }
    
    private void helper(List<String> res, String s, int pos, int seq, String path) {
        if (seq == 4 && pos == s.length()) {
            res.add(path);
            return;
        }
        if (pos == s.length() || seq == 4) return;
        
        for (int i = 1; i <= 3; i++) {
            if (pos + i > s.length() || s.charAt(pos) == '0' && i > 1) break;
            String val = s.substring(pos, pos + i);
            if (Integer.parseInt(val) <= 255) {
                if (pos == 0) helper(res, s, pos + i, seq + 1, val);
                else helper(res, s, pos + i, seq + 1, path + '.' + val);
            }
        }
        
    }
    
    public static void main(String[] args) {
        _93_RestoreIPAddresses test = new _93_RestoreIPAddresses();
        test.restoreIpAddresses("172162541");
    }
}
