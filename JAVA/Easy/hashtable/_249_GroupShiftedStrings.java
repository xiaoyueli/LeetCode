package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * 
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

    "abc" -> "bcd" -> ... -> "xyz"
    Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
    
    For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
    A solution is:
    
    [
      ["abc","bcd","xyz"],
      ["az","ba"],
      ["acef"],
      ["a","z"]
    ]
 * 
 * 
 * 思路：
 * 能相互转化的字符串，相同位置的各字母间的差值是一样的，因此在基础字符上可以利用相同的差值生成同样的字符串，因此利用hashmap将此字符串作为key，能生成同样key的就是一组
 */

public class _249_GroupShiftedStrings {
    
    public List<List<String>> groupStrings(String[] strings) {
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String str: strings) {
            StringBuilder sb = new StringBuilder();
            
            char[] seq = str.toCharArray();
            for (int i = 0; i + 1 < seq.length; i++) {
                char c = getPrototype(seq, i);
                sb.append(c);
            }
            
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (List<String> ls: map.values()) res.add(ls);
        return res;
    }
    
    private char getPrototype(char[] seq, int i) {
        int diff = seq[i] - seq[i + 1];
        if (diff < 0) diff += 26;
        return (char)('a' + diff);
    }

}
