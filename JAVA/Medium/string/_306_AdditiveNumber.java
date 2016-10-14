package string;

/**
 * @author xiaoyue
 * 
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. 
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * 
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 
 * 1 + 99 = 100, 99 + 100 = 199
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * 
 * Follow up:
 * How would you handle overflow for very large input integers?
 * 
 * 思路：
 * 遍历第一和第二个字符的组合，然后依次验证，因为确定了第一和第二个数字，后面的数字就确定了
 * 因为additive seq至少三个数字，而第三个数字肯定是大于前两个数字的，也就是第三个数字的长度为大于前两个数字的长度
 * 因此第一个数字的长度范围为总长度len / 2
 * 第二个数字的长度范围动态调整, 保证第三个数字的长度大于等于前两个数字的最大值： len - len1 - len2 >= Math.max(len1, len2)
 * 
 * notice: subNum 的头字符不能为0，除非是0这个数字
 */

public class _306_AdditiveNumber {
    
    public boolean isAdditiveNumber(String num) {
        
        int len = num.length();
        
        for (int len1 = 1; len1 <= len / 2; len1++) {
            for (int len2 = 1; len - (len1 + len2) >= Math.max(len1, len2); len2++) {
                if (isValid(num.substring(0, len1), num.substring(len1, len1 + len2), len1 + len2, num)) return true;
            }
        }
        
        return false;
    }
    
    private boolean isValid(String s1, String s2, int sta, String num) {

        int len = num.length();
        if (!(isValidNum(s1) && isValidNum(s2))) return false;
        for (int idx = sta; idx < len; ) {
            
            String resStr = compute(s1, s2);
            int lres = resStr.length();
            if (idx + lres > len) return false;
            if (resStr.equals(num.substring(idx, idx + lres))) {
                s1 = s2;
                s2 = resStr;
                idx = idx + lres;
            }
            else return false;
        }
        
        return true;
        
    }
    
    private boolean isValidNum(String str) {
        if (str.charAt(0) == '0' && str.length() != 1) return false;
        return true;
    }
    
    private String compute(String num1, String num2) {
        
        char[] seq1 = num1.toCharArray();
        char[] seq2 = num2.toCharArray();
        
        int len1 = seq1.length, len2 = seq2.length;
        int idx1 = len1 - 1, idx2 = len2 - 1;
        
        StringBuilder sb = new StringBuilder();
        int surplus = 0;
        while (idx1 >= 0 && idx2 >= 0) {
            int val1 = seq1[idx1--] - '0';
            int val2 = seq2[idx2--] - '0';
            
            int cur = val1 + val2 + surplus;
            int val = cur % 10;
            surplus = cur / 10;
            
            sb.insert(0, val);
        }
        
        if (idx1 >= 0) addLeftDigits(seq1, idx1, surplus, sb);
        if (idx2 >= 0) addLeftDigits(seq2, idx2, surplus, sb);
        if (idx1 < 0 && idx2 < 0 && surplus > 0) sb.insert(0, surplus);
        
        return sb.toString();
    }
    
    private void addLeftDigits(char[] seq, int sta, int surplus, StringBuilder sb) {
        while (sta >= 0) {
            int val = seq[sta--] - '0';
            int dig = (val + surplus) % 10;
            surplus = (val + surplus) / 10;
            sb.insert(0, dig);
        }
        if (surplus != 0) sb.insert(0, surplus);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        _306_AdditiveNumber test = new _306_AdditiveNumber();
        test.isAdditiveNumber("121474836472147483648");
        
        String str = test.compute("12345", "97890");
//        System.out.println(str);

    }

}
