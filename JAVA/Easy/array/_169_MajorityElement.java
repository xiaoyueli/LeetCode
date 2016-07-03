package array;

import java.util.Arrays;
import java.util.Hashtable;

public class _169_MajorityElement {
    
    public int majorityElement(int[] nums) {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for (int idx = 0; idx < nums.length; idx++) {
            int amount;
            if (table.containsKey(nums[idx])) {
                amount = table.get(nums[idx]);
                amount++;
            }
            else {
                amount = 1;
            }

            if (amount > nums.length / 2) return nums[idx];
            else table.put(nums[idx], amount);
        }
        return -1;
    }
    
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int major = nums[0];
        int last = nums[0];
        int maxlen = 1;
        int len = 1;
        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx] != last) {
                if (len > maxlen) {
                    maxlen = len;
                    major = nums[idx - 1];
                }
                len = 1;
                last = nums[idx];
            }
            else len++;
        }
        
        if (len > maxlen) major = nums[nums.length - 1];
        
        
        return major;
    }
    
    public int majorityElement3(int[] nums) {
        // 因为major总是存在（数量大于n/2）
        // 所以不需要排序，major累计出的数量不会通过count-- 抵消到0
        
        int major = nums[0];
        int cnt = 1;
        for (int idx = 1; idx < nums.length; idx++) {
            if (cnt == 0) {
                cnt++;
                major = nums[idx];
            }
            else if (major == nums[idx]) cnt++;
            else cnt--;
            
            
        }
        
        return major;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _169_MajorityElement test = new _169_MajorityElement();
        int result = test.majorityElement3(new int[]{1,2,2,2,5,3,5,2});
        System.out.println(result);
    }

}
