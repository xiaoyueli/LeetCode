package topoLogicalSort;

/**
 * There is a new alien language which uses the latin alphabet. 
 * However, the order among letters are unknown to you. 
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
 * Derive the order of letters in this language.

    For example,
    Given the following words in dictionary,
    
    [
      "wrt",
      "wrf",
      "er",
      "ett",
      "rftt"
    ]
    The correct order is: "wertf".
    
    Note:
    You may assume all letters are in lowercase.
    If the order is invalid, return an empty string.
    There may be multiple valid order of letters, return any one of them is fine.
 *
 * 思路，遍历word，确定字符前后关系，
 * 然后用que + degree数组，确定关系是否valid.
 * 
 * notice: 确定字符关系时，只考虑两个word相同位子的字符的前后关系，同一个word字符内部的字符间无先后关系，短的字符串前于长的字符串
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _269_AlienDictionary {
    
    public String alienOrder(String[] words) {
        
        if (words.length == 1) return words[0];
        HashMap<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
        int[] degree = new int[26];
        for (int i = 0; i < 26; i++) {
            degree[i] = -1;
            map.put((char)('a' + i), new HashSet<Character>());
        }
        
        boolean isValid = getOrder(words, map, degree);
        if (!isValid) return "";
        
        return checkOrder(map, degree);
        
    }
    
    private boolean getOrder(String[] words, HashMap<Character, HashSet<Character>> map, int[] degree) {
        
        String last = words[0];
        for (int i = 1; i< words.length; i++) {
            String cur = words[i];
            
            int idxc = 0;
            int idxl = 0;
            while (idxc < cur.length() && idxl < last.length() && cur.charAt(idxc) == last.charAt(idxl)) {
                if (degree[last.charAt(idxl) - 'a'] == -1) degree[last.charAt(idxl) - 'a'] = 0;
                idxc++;
                idxl++;
            }
            
            if (idxl < last.length() && idxc == cur.length()) return false;
            
            if(idxl < last.length() && idxc < cur.length()) {
                add(map, degree, last.charAt(idxl), cur.charAt(idxc));
                idxl++;
                idxc++;
            }
            
            while (idxl < last.length()) {
                if (degree[last.charAt(idxl) - 'a'] == -1) degree[last.charAt(idxl) - 'a'] = 0;
                idxl++;
            }
            
            while (idxc < cur.length()) {
                if (degree[cur.charAt(idxc) - 'a'] == -1) degree[cur.charAt(idxc) - 'a'] = 0;
                idxc++;
            }
            
            last = cur;
        }
        return true;
    }
    
    private void add(HashMap<Character, HashSet<Character>> map, int[] degree, char pre, char post) {
        
        if (degree[pre - 'a'] == -1) degree[pre - 'a'] = 0;
        if (pre == post || map.get(pre).contains(post)) return;
        map.get(pre).add(post);
        if (degree[post - 'a'] == -1) degree[post - 'a'] = 0;
        degree[post - 'a']++;
    }
    
    private String checkOrder(HashMap<Character, HashSet<Character>> map, int[] degree) {
        
        Queue<Character> que = new LinkedList<Character>();
        
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) que.offer((char)('a' + i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!que.isEmpty()) {
            char cur = que.poll();
            sb.append(cur);
            
            HashSet<Character> set = map.get(cur);
            if (set.isEmpty()) continue;
            
            for (char c: set) {
                degree[c - 'a']--;
                if (degree[c - 'a'] == 0) que.offer(c);
            }
        }
        
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] > 0) return "";
        }
        
        return sb.toString();
        
    }

}
