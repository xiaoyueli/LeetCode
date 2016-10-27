package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两重循环确定数1数2
 * 数3数4用two pointer遍历从两头逼近
 * 注意去除重复元素
 */

public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        int len = nums.length;
        if (len < 4) return res;
        Arrays.sort(nums);
        
        for (int one = 0; one < len - 3; one++) {
            
            if (one != 0 && nums[one] == nums[one - 1]) continue;  // 去除重复元素
            
            for (int two = one + 1; two < len - 2; two++) {
                
                if (two != one + 1 && nums[two] == nums[two - 1]) continue; // 去除重复元素
                
                int three = two + 1;
                int four = len - 1;
                
                while (three < four) {
                    int sum = nums[one] + nums[two] + nums[three] + nums[four];
                    
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[one]);
                        temp.add(nums[two]);
                        temp.add(nums[three]);
                        temp.add(nums[four]);
                        res.add(temp);
                        three++;
                        four--;
                        while (three < four && nums[three] == nums[three - 1]) three++;
                        while (four > three && nums[four] == nums[four + 1]) four--;
                    }
                    else if (sum > target) four--;
                    else three++;
                }
            }
        }
        
        return res;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
