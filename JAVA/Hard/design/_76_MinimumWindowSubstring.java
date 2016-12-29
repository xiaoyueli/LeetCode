package design;

import java.util.HashMap;

/**
 * 
 * @author xiaoyue
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    For example,
    S = "ADOBECODEBANC"
    T = "ABC"
    Minimum window is "BANC".
    
    Note:
    If there is no such window in S that covers all characters in T, return the empty string "".
    
    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * 思路：
 * greedy: right pointer不断加入char，直到匹配到所有字符。然后left像right逼近删除加入的字符，直到不再匹配。 期间更新最小长度和字符串
 * 
 * 数据结构，自己设计了一个类。用HashMap. key 存char. value 存长度为2的int[]数组用于记录加入的字符，位置0初始化pattern的字符数，位子1动态记录加入删除的字符数
 * 
 */

public class _76_MinimumWindowSubstring {
    
    class Match {
        
        HashMap<Character, int[]> map;
        int size;
        int checksize;
        
        public Match(String ori) {
            
            map = new HashMap<Character, int[]>();
            char[] seq = ori.toCharArray();
            size = 0;
            checksize = 0;
            
            for (char c: seq) {
                if (!map.containsKey(c)) map.put(c, new int[2]);
                map.get(c)[0]++;
                size++;
            }
            
        }
        
        public void add(char c) {
            if (map.containsKey(c)) {
                int[] nums = map.get(c);
                nums[1]++;
                if (nums[0] >= nums[1]) checksize++;
            }
        }
        
        public void remove(char c) {
            if (map.containsKey(c)) {
                int[] nums = map.get(c);
                nums[1]--;
                if (nums[0] > nums[1]) checksize--;
            }
        }
        
        public boolean isFound() {
            return size == checksize;
        }
    }
    
    public String minWindow(String s, String t) {
        
        if (t.length() > s.length()) return "";
        
        Match map = new Match(t);
        
        String res = "";
        int min = Integer.MAX_VALUE;
        
        int left = 0;
        int right = 0;
        
        while (right < s.length()) {
            
            while (right < s.length() && !map.isFound()) map.add(s.charAt(right++));
            if (map.isFound() && min > right - left) {
                min = right - left;
                res = s.substring(left, right);
            }          
            
            while (left <= right && map.isFound()) {
                
                if (min > right - left) {
                    min = right - left;
                    res = s.substring(left, right);
                }
                map.remove(s.charAt(left++));
                
            }
        }
        
        return res;
            
    }
}
