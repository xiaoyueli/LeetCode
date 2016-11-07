package hashtable;

import java.util.HashMap;
import java.util.Hashtable;

/**
 *  用数组map字母，若字母出现就把出现的位子保存到map的数组里
 *  数组效率高于hashtable
 */

public class _205_IsomorphicStrings {
    
    
    // 方法1
    public boolean isIsomorphic(String s, String t) {
        
        int len = s.length();
        if (len != t.length()) return false;
        
        int[] marks = new int[128];
        int[] markt = new int[128];
        
        for (int idx = 0; idx < len; idx++) {
            char cs = s.charAt(idx);
            char ct = t.charAt(idx);
            if (marks[cs] == 0 && markt[ct] == 0) {
                marks[cs] = idx + 1;
                markt[ct] = idx + 1;
            }
            else if (marks[cs] == 0) return false;
            else if (markt[ct] == 0) return false;
            else if (marks[cs] != markt[ct]) return false;
        }
        
        return true;   
    }
    
    // 方法2
    public boolean isIsomorphic1(String s, String t) {
        
        int len = s.length();
        if (len != t.length()) return false;
        
        int[] marks = helper(s);
        int[] markt = helper(t);
        
        for (int idx = 0; idx < len; idx++) {
            if (marks[idx] != markt[idx]) return false;
        }
        
        return true;
        
    }
    
    private int[] helper(String s) {
        
        char[] seq = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int len = seq.length;
        int[] res = new int[len];
        
        for (int idx = 0; idx < len; idx++) {
            char c = seq[idx];
            if (map.containsKey(c)) res[idx] = map.get(c);
            else {
                res[idx] = idx;
                map.put(c, idx);
            }
        }
        return res;
    }
    
    // 方法3
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        Hashtable<Character, Character> tableS = new Hashtable<Character, Character>();
        Hashtable<Character, Character> tableT = new Hashtable<Character, Character>();
        
        for (int idx = 0; idx < s.length(); idx++) {
            if (tableS.containsKey(s.charAt(idx))) {
                char ct = tableS.get(s.charAt(idx));
                if (ct != t.charAt(idx)) return false;
            }
            if (tableT.containsKey(t.charAt(idx))) {
                char st = tableT.get(t.charAt(idx));
                if (st != s.charAt(idx)) return false;
            }
            tableS.put(s.charAt(idx), t.charAt(idx));
            tableT.put(t.charAt(idx), s.charAt(idx));
        }
        return true;
    }
}