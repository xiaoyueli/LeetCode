package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 两重循环确定数1数2
 * 数3数4用二分法遍历从两头逼近
 * 用SET去除重复
 */

public class _18_4Sum {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int sum;
        for (int one = 0; one < nums.length; one++) {
            for (int two = one + 1; two < nums.length - 2; two++) {
                
                int three = two + 1;
                int four = nums.length - 1;
                
                while (three < four) {
                    sum = nums[one] + nums[two] + nums[three] + nums[four];
                    
                    if (sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[one]);
                        list.add(nums[two]);
                        list.add(nums[three]);
                        list.add(nums[four]);
                        set.add(list);
                        four--;
                        three++;
                    }
                    else if (sum > target) four--;
                    else if (sum < target) three++;
                }
            }
        }
        
        
        for (List<Integer> l: set) {
            result.add(l);
        }
        
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
