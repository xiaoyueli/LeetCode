package array;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
    
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(1);
        res.add(ls);
        
        int row = 1;
        
        while (row < numRows) {
            List<Integer> cur = new ArrayList<Integer>();
            
            int len = row;
            cur.add(1);
            
            for (int idx = 0; idx < len - 1; idx++) {
                int val = ls.get(idx) + ls.get(idx + 1);
                cur.add(val);
            }
            
            cur.add(1);
            res.add(cur);
            ls = cur;
            
            row++;
        }
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
