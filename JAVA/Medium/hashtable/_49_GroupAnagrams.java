package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * [
      ["ate", "eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
 *
 * Note: All inputs will be in lower-case.
 * 
 * 将字母排序后做hashtable的key
 * value 存arraylist
 * 
 */

public class _49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map  = new HashMap<String, List<String>>();
        
        for (int idx = 0; idx < strs.length; idx++) {
            String s = strs[idx];
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (map.containsKey(key)) map.get(key).add(s);
            else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
            }
        }
        
        List<List<String>> res = new ArrayList<>(map.values());
        
        return res;
    }
}
