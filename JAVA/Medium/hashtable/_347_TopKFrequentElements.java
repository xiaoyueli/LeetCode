package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 *
 */

public class _347_TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer>[] bucket = new List[nums.length + 1];
    
        for (int i: nums) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        
        for (int i: map.keySet()) {
            int val = map.get(i);
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<Integer>();
            }
            bucket[val].add(i);
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for (int idx = nums.length; idx >= 0 && res.size() < k; idx--) {
            if (bucket[idx] == null) continue;
            res.addAll(bucket[idx]);
        }
        
        return res;
    }
}