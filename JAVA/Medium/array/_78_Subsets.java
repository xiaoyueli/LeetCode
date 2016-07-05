package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 当加入第k个元素时，新的组合集合等于旧的组合集合+（旧的组合集合中每一个组合+元素k）
 *  从空集开始加
 */

public class _78_Subsets {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());  // 加入空集
        
        for (int idx = 0; idx < nums.length; idx++) {
            List<List<Integer>> list = new ArrayList<>();
            for (List<Integer> sub: res) {
                list.add(sub);
                List<Integer> newlist = new ArrayList(sub);
                newlist.add(nums[idx]);
                list.add(newlist);
            }
            res = list;
        }
        return res;
    }
}
