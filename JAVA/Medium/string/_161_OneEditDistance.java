package string;

/**
 * 
 * @author xiaoyue
 * Given two strings S and T, determine if they are both one edit distance apart.
 * 
 * edit distance is the steps needed to convert string1 to string2
 * 
 * (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a string:
    
    a) Insert a character
    b) Delete a character
    c) Replace a character
 * 
 * 题意：判断S 和 T是否通过编辑一次就能相互转化
 * 思路:
 * 先确定S和T的长度是否相差大于1，大于1返回false
 * 如果S和T 相等，遇到不相等的字符，判断后面的字符是否相等
 * 如果S和T不相等，遇到不相等 的字符，判断短的字符串，从当前字符开始，剩余的字符，是否和长的字符串从下一个字符开始的剩余字符相等
 * 
 */

public class _161_OneEditDistance {    

    public boolean isOneEditDistance(String s, String t) {
        
        if (s.length() < t.length()) return isOneEditDistance(t, s);
        
        if (s.length() == t.length()) return check(s, t, 1);
        if (s.length() - t.length() > 1) return false;
        
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) return check(s.substring(i + 1), t.substring(i), 0);
        }
        
        return true;
    }
    
    private boolean check(String s, String t, int dif) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) cnt++;
            if (cnt > dif) return false;
        }
        return cnt == dif;
    }
    
}
