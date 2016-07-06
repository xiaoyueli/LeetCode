package hashtable;

import java.util.Hashtable;

/**
 *  用数组map字母，若字母出现就把出现的位子保存到map的数组里
 *  数组效率高于hashtable
 */

public class _205_IsomorphicStrings {
    
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) return false;
        
        int[] ls = new int[128];
        int[] lt = new int[128];
        
        for (int idx = 0; idx < s.length(); idx++) {

            if (ls[s.charAt(idx)] != 0 && lt[t.charAt(idx)] != 0) {
                int lastIndexS = ls[s.charAt(idx)];
                int lastIndexT = lt[t.charAt(idx)];
                if (lastIndexS != lastIndexT) return false;
            } 
            else if (ls[s.charAt(idx)] != 0) return false;
            else if (lt[t.charAt(idx)] != 0) return false;
            
            ls[s.charAt(idx)] = idx + 1;
            lt[t.charAt(idx)] = idx + 1;
        }
        
        return true;
        
    }
    
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