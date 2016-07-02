package array;

import java.util.Hashtable;

public class _219_ContainsDuplicate2 {
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for (int idx = 0; idx < nums.length; idx++) {
            if (table.containsKey(nums[idx])) {
                int other = table.get(nums[idx]);
                if (idx - other <= k) return true;
            }
            table.put(nums[idx], idx);
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3 ,4, 1 ,2, 5 ,6};
        _219_ContainsDuplicate2 test = new _219_ContainsDuplicate2();
        boolean result = test.containsNearbyDuplicate(arr, 5);
        System.out.println(result);
    }
}
