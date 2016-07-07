package array;

/**
 * Given an integer array of size n, 
 * find all elements that appear more than n/3 times. 
 * The algorithm should run in linear time and in O(1) space.
 * 
 * 出现次数大于n/3次的数最多只能有2个（总数分成三份，只能有两份大于三分之一）
 * 如果存在这样的数，major累计的数量和不会被非major的数抵消完
 * 
 * 最后不必定存在这样的数，遍历检验
 * 
 * O(N)
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _229_MajorityElement2 {
    
    public List<Integer> majorityElement(int[] nums) {
        
        int maj1 = 0;
        int maj2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        
        for (int num: nums) {
            if (maj1 == num) cnt1++;
            else if (maj2 == num) cnt2++;
            else if (cnt1 == 0) {
                maj1 = num;
                cnt1++;
            }
            else if (cnt2 == 0) {
                maj2 = num;
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        
        cnt1 = 0;
        cnt2 = 0;
        for (int num: nums) {
            if (num == maj1) cnt1++;
            else if (num == maj2) cnt2++;
        }
        
        List<Integer> res = new ArrayList<Integer>();
        if (cnt1 > nums.length / 3) res.add(maj1);
        if (cnt2 > nums.length / 3) res.add(maj2);
        
        return res;
    }
}
