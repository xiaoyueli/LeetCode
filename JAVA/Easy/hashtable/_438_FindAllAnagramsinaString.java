package hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *  
 *  思路：
 *  方法一，用两个26的数组记录p字符出现的次数，和长度同p的window在S里字符出现的字符，
 *  每次check他们是否是Anagrams后，更新window的值
 *  
 *  方法二，用一个flag记录新的check信号，如果上一个字符串是anagrams，则只需比较当前字符串第一个字符和p长度等长的下一个起始字符是否相同，如果是，则下一个位置也加入list
 *  否者就重新比较
 *  
 */

public class _438_FindAllAnagramsinaString {
    
    // 法1
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<Integer>();
        int len = p.length();
        int length = s.length();
        if (len == 0 || length == 0 || len > length) return res;
        
        char[] seqs = s.toCharArray();
        char[] seqp = p.toCharArray();
        
        int[] pattern = new int[26];
        int[] window = new int[26];
        
        for (int idx = 0; idx < len; idx++) {
            pattern[seqp[idx] - 'a']++;
            window[seqs[idx] - 'a']++;
        }
        
        
        for (int idx = 0; idx + len <= length; idx++) {
            if (isAnagrams(pattern, window)) res.add(idx);
            window[seqs[idx] - 'a']--;
            if (idx + len < length) window[seqs[idx + len] - 'a']++;
        }
        
        
        return res;
        
    }
    
    private boolean isAnagrams(int[] pat, int[] window) {
        
        for (int idx = 0; idx < 26; idx++) {
            if (pat[idx] != window[idx]) return false;
        }
        
        return true;
    }
    
    // 法2
    public List<Integer> findAnagrams2(String s, String p) {
        
        char[] seqs = s.toCharArray();
        int length = seqs.length;
        int len = p.length();
        
        int[] mark = getMark(p);
        
        List<Integer> res = new ArrayList<Integer>();
        boolean newCheck = true;
        char keep = ' ';
        
        int idx = 0;
        while (idx + len <= length) {
            if (newCheck) {
                String sub = s.substring(idx, idx + len);
                if (isAna(sub, copy(mark))) {
                    res.add(idx);
                    newCheck = false;
                    keep = seqs[idx];
                }
                idx++;
            }
            else if (idx + len - 1>= length) break;
            else{
                if (keep == seqs[idx + len - 1]) {
                    res.add(idx);
                    keep = seqs[idx];
                    idx++;
                    continue;
                }
                else if (!isValid(seqs[idx + len - 1], mark)) idx = idx + len;
                else idx++;
                newCheck = true;
            }
        }
        
        return res;
    }
    
    private int[] getMark(String p) {
        char[] seqp = p.toCharArray();
        int[] seq = new int[26];
        
        for (char c: seqp) {
            seq[c - 'a']++;
        }
        
        return seq;
    }
    
    private boolean isValid(char c, int[] mark) {
        return mark[c - 'a'] != 0;
    }
    
    private int[] copy(int[] ori) {
        int[] newOne = new int[26];
        
        for (int idx = 0; idx < 26; idx++) {
            newOne[idx] = ori[idx];
        }
        
        return newOne;
    }
    
    private boolean isAna(String str, int[] mark) {
        char[] seq = str.toCharArray();
        
        for (char c: seq) {
            if (mark[c - 'a'] == 0) return false;
            mark[c - 'a']--;
        }
        
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
