package string;

/**
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 * 
 * @author xiaoyue
 *
 */

public class _151_ReverseWordsinaString {
    
    public String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();
        String[] seq = s.split(" ");
        
        int len =  seq.length;
        
        for (int idx = len - 1; idx >= 0; idx--) {
            if (seq[idx].equals("")) continue;
            sb.append(seq[idx] + " ");
        }
        
        if (sb.length() == 0) return "";
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
        
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        _151_ReverseWordsinaString test = new _151_ReverseWordsinaString();
//        test.reverseWords("1 2 3 4 5");
        
        
        StringBuilder sb = new StringBuilder();
        String str = " 1 2 3 4 5 ";   
        String[] seq = str.split("");
        for (String s: seq) System.out.println(s);
    }

}
