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
    
    String info;
    StringBuilder candi = new StringBuilder();
    List<String> res = new ArrayList<String>();
    int len;
    public List<String> restoreIpAddresses(String s) {
        info = s;
        len = info.length();
        if (len < 4) return res;
        else bc(0, 0);
        return res;
    }
    
    
    public void bc(int pos, int level) {
        if (pos >= len) {
            if (level == 4) {
                int len = candi.length();
                res.add(candi.toString().substring(0, len - 1));
            }
            return;
        }
        if (level == 4) {
            return;
        }

        for (int idx = 1; idx <= 3; idx++) {
            String s;
            
            if (pos + idx > len) s = info.substring(pos, len);
            else s = info.substring(pos, pos + idx);
            if (idx > 1 && s.charAt(0) == '0') return; //丢掉第一个字符为0的组合
            int val = Integer.parseInt(s);
            if (val > 255) return;  //丢掉大于255的组合
            
            candi.append(s + ".");
            bc(pos + idx, level + 1);

            int templen = candi.length();
            int sublen = s.length();
            candi.delete(templen - sublen - 1, templen); // 删除本轮加入的字符串
            if (templen >= len + 4) break; // 如果本轮加入的字符串总长已经超限，结束此轮循环


        }
    }
    
    public static void main(String[] args) {
        _93_RestoreIPAddresses test = new _93_RestoreIPAddresses();
        test.restoreIpAddresses("172162541");
    }
}
