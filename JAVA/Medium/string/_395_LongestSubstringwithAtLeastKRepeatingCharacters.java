package string;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) 
 * such that every character in T appears no less than k times.
 * 
 * Example 1:
 * Input:
 * s = "aaabb", k = 3
 * 
 * Output:
 * 3
 * 
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * 
 * Example 2:
 * Input:
 * s = "ababbc", k = 2
 * 
 * Output:
 * 5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * 
 * @author xiaoyue
 * 
 * 遍历字符串，将小于K的字符作为分隔符分割出subStrings
 * 然后递归
 *
 */

public class _395_LongestSubstringwithAtLeastKRepeatingCharacters {
	
    public int longestSubstring(String s, int k) {
        
        String[] subStrings = getValidSubString(s, k);
        if (subStrings == null) return s.length();
        
        int max = 0;
        for (String str: subStrings) {
            if (str.length() <= max) continue;
        	int val = longestSubstring(str, k);
        	if (val > max) max = val;
        }
       
        return max;
    }
    
    private String[] getValidSubString(String s, int k) {
        
        char[] seq = s.toCharArray();
        int[] countChar = new int[26];
        for (char c: seq) countChar[c - 'a']++;
        
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < 26; idx++) {
        	int val = countChar[idx];
            if ( val != 0 && val < k) 
            	sb.append((char)('a' + idx) + "|");
        }
        
        if (sb.length() == 0) return null;
        sb.deleteCharAt(sb.length() - 1);
        String[] res = s.split(sb.toString());
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_395_LongestSubstringwithAtLeastKRepeatingCharacters test = new _395_LongestSubstringwithAtLeastKRepeatingCharacters();
		int val = test.longestSubstring("ababbcepccowattac", 2);
		System.out.println(val);
		
	}

}
