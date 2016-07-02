package array;

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
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
