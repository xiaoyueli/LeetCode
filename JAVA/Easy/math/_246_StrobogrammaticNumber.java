package math;

/**
 * 
 * @author xiaoyue
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * 
 * 题意，判断旋转180度后是否上下左右对称
 * 满足条件的数字，0，1，8， 6/9
 * 然后从左右从中间遍历判断
 * 
 * 注意当数字为1和数组为奇数时单独判断中间的数
 *
 */

public class _246_StrobogrammaticNumber {
    
    public boolean isStrobogrammatic(String num) {
        
        char[] seq = num.toCharArray();
        int len = seq.length;
        
        if (len == 1) return seq[0] == '0' || seq[0] == '1' || seq[0] == '8';
        
        int left = 0;
        int right = len - 1;
        
        
        while (left < right) {
            if (isStrobo(seq[left], seq[right])) {
                left++;
                right--;
            }
            else return false;
        }
        
        if (len % 2 != 0) return seq[left] == '0' || seq[left] == '1' || seq[left] == '8';
        
        return true;
    }
    
    private boolean isStrobo(char c1, char c2) {
        
        if (c1 == c2 && c1 == '0') return true;
        if (c1 == c2 && c1 == '1') return true;
        if (c1 == c2 && c1 == '8') return true;
        if (c1 == '6' && c2 == '9' || c1 == '9' && c2 == '6') return true;
        
        return false;
    }

}
