package array;

import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSum3 {
    
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<Integer>();
    int target;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        target = n;
        search(1, k, 0);
        return res;
    }
    
    public void search(int col, int amount, int sum) {
        if (amount == 0) {
            if (sum == target) {
                List<Integer> newOne = new ArrayList<Integer>(list);
                res.add(newOne);
                return;
            }
            else if (sum > target) return;
        }
        
        for (int num = col; num < 10; num++) {
            sum += num;
            list.add(num);
            search(num + 1, amount - 1, sum);
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }
}
