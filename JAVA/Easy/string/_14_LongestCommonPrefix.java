package string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

public class _14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        
        int cnt = 0;
        int len = strs.length;
        if (len == 0) return "";
        if (len == 1) return strs[0];
        boolean flag = true;
        int ceiling = strs[0].length();
        
        while (cnt < ceiling) {
            char c = strs[0].charAt(cnt);
            for (int idx = 1; idx < len; idx++) {
                if (cnt >= strs[idx].length()) {
                    flag = false;
                    break;
                }
                else {
                    char other = strs[idx].charAt(cnt);
                    if (c != other) {
                        flag = false;
                        break;
                    } 
                }
            }
            
            if (!flag) break;
            
            cnt++;
        }
        
        
        if (cnt == 0) return "";
        return strs[0].substring(0, cnt);
        
    }
    
    public static void main(String[] args) {
        _14_LongestCommonPrefix test = new _14_LongestCommonPrefix();
        String s = "123";
        System.out.println(s.substring(0, 0));
    }
}
