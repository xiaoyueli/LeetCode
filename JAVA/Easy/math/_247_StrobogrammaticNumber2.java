package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyue
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

    Find all strobogrammatic numbers that are of length = n.
    
    For example,
    Given n = 2, return ["11","69","88","96"].
    
    Hint:
    Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 * 
 *  思路，数组可以重复的combination，
 *  建立N一半大小的数组，找可能的组合，满足条件的情况，再将数组扩大，对称复制，加入list
 *  
 *  注意：
 *  1.第一个字符不能为0，或者 n == 1;
 *  2.当n为奇数时，组合的最后一个字符不能为6或9
 *  3.复制的时候，如果当前为6，对称位为9
 *
 */

public class _247_StrobogrammaticNumber2 {
    
    int n;
    public List<String> findStrobogrammatic(int n) {
        
        List<String> res = new ArrayList<String>();
        this.n = n;
        
        int len = (n + 1) / 2;
        char[] seq = new char[len];
        char[] nums = new char[]{'0', '1', '6', '8', '9'};
        
        helper(res, nums, seq, 0, len);
        
        return res;
        
    }
    
    private void helper(List<String> res, char[] nums, char[] seq, int pos, int len) {
        if (pos == len) {
            if ((seq[0] != '0' || n == 1) && (n % 2 == 0 || seq[len - 1] != '6' && seq[len - 1] != '9')) {
                String str = copyLeftHalf(seq);
                res.add(str);
            }
            return;
        }
        int length = nums.length;
        
        for (int i = 0; i < length; i++) {
            seq[pos] = nums[i];
            helper(res, nums, seq, pos + 1, len);
        }
    }
    
    private String copyLeftHalf(char[] seq) {
        
        int len = seq.length;
        char[] copy = new char[n];
        
        for (int idx = 0; idx < len; idx++) {
            copy[idx] = seq[idx];
            if (seq[idx] == '6') copy[n - 1 - idx] = '9';
            else if (seq[idx] == '9') copy[n - 1 - idx] = '6';
            else copy[n - 1 - idx] = seq[idx];

        }
        
        return new String(copy);
    }

}
