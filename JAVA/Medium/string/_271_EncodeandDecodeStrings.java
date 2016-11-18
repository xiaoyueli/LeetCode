package string;

import java.util.ArrayList;

/**
 * Design an algorithm to encode a list of strings to a string. 
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 * 
 * Machine 1 (sender) has the function:
 * 
 * string encode(vector<string> strs) {
 * // ... your code
 * return encoded_string;
 * }
 * 
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 * //... your code
 * return strs;
 * }
 * 
 * So Machine 1 does:
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 * 
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * 
 * 
 * Implement the encode and decode methods.
 * 
 * Note:
 * The string may contain any possible characters out of 256 valid ascii characters. 
 * Your algorithm should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 * 
 * 思路，
 * 保存字符串长度，进行处理，（各种方法，这里使用了每个字符+数字，也可以直接在字符串里加特殊字符）；
 */

import java.util.List;

public class _271_EncodeandDecodeStrings {

    // Encodes a list of strings to a single string.
    int[] map;
    public String encode(List<String> strs) {
        
        StringBuilder sb = new StringBuilder();
        int size = strs.size();
        map = new int[size];
        
        
        for (int idx = 0; idx < size; idx++) {
            char[] seq = strs.get(idx).toCharArray();
            int len = seq.length;
            map[idx] = len;
            for (int i = 0; i < len; i++) seq[i] += len;
            sb.append(new String(seq));
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        List<String> res = new ArrayList<String>();
        
        int i = 0, j = 0;
        int length = map.length;
        
        while (i < length) {
            char[] seq = s.substring(j, j + map[i++]).toCharArray();
            j += seq.length;
            
            for (int idx = 0; idx < seq.length; idx++) seq[idx] -= seq.length;
            res.add(new String(seq));
        }
        
        return res;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
