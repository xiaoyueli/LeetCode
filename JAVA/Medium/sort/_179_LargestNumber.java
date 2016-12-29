package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, 
 * arrange them such that they form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], 
 * the largest formed number is 9534330.
 * 
 * Note: The result may be very large, 
 * so you need to return a string instead of an integer.
 *
 * 把数字转换成字符串，拼接两个字符串，后进行比较
 * 需重新写comparator 后进行排序
 *
 */

public class _179_LargestNumber {
    public String largestNumber(int[] nums) {
        
        int len = nums.length;
        String[] str = new String[len];
        
        for (int idx = 0; idx < len; idx++) {
            str[idx] = nums[idx] + "";    
        }
        
        Comparator<String> myCom = new Comparator<String>() {
            
            @Override
            public int compare(String a, String b) {
                String s1 = a + b;
                String s2 = b + a;
                return s1.compareTo(s2);
            }
        };
        
        Arrays.sort(str, myCom);
        
        StringBuffer sb = new StringBuffer();
        for (int idx = str.length - 1; idx >= 0; idx--) {
            sb.append(str[idx]);
        }
        
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
        
    }
}

