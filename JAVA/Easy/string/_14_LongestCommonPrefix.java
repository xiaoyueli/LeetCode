package string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

public class _14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder sb = new StringBuilder();
        int length = strs.length;
        int len = 0;
        boolean isCom = true;

        while (length > 0) {
            
            if (strs[0].length() == len) break;
            
            char c = strs[0].charAt(len);
            for (int idx = 1; idx < length; idx++) {

                if (strs[idx].length() == len || strs[idx].charAt(len) != c) {
                    isCom = false;
                    break;
                }
            }
            if (!isCom) break;
            sb.append(c);
            len++;
        }
        
        return sb.toString();
        
    }
    
    public static void main(String[] args) {
        _14_LongestCommonPrefix test = new _14_LongestCommonPrefix();
        String s = "123";
        System.out.println(s.substring(0, 0));
    }
}
