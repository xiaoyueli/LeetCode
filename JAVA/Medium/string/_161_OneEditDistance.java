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
        
        char[] shorter = s.toCharArray();
        char[] longer = t.toCharArray();
        
        int slen = shorter.length;
        int llen = longer.length;
        if (llen < slen) {
            char[] temp = longer;
            longer = shorter;
            shorter = temp;
            
            llen = longer.length;
            slen = shorter.length;
        }
        
        if (llen - slen > 1) return false;
        
        int i = 0;
        for (; i < slen; i++) {
            if (shorter[i] == longer[i]) continue;
            if (slen == llen) return checkEquals(shorter, i + 1, slen - 1, longer, i + 1, slen - 1);
            else return checkEquals(shorter, i, slen - 1, longer, i + 1, llen - 1);
        }
        
        return slen != llen;
    
    }

    private boolean checkEquals(char[] seq1, int s1, int e1, char[] seq2, int s2, int e2) {
        while (s1 <= e1 && s2 <= e2) {
            if (seq1[s1++] != seq2[s2++]) return false;
        }
        
        return true;
    }
    
    

}
