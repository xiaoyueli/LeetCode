package array;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
    
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList<>();
        int row = 0;
        while (row < numRows) {
            
            List<Integer> sublist = new ArrayList<Integer>();
            
            if (list.size() == 0) {
                sublist.add(1);
            }
            else {
                List<Integer> lastlist = list.get(row - 1);
                
                sublist.add(1);
                for (int idx = 1; idx < row; idx++) {
                    sublist.add(lastlist.get(idx - 1) + lastlist.get(idx));
                }
                sublist.add(1);
            }
            
            list.add(sublist);
            row++;
        }
        
        return list;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
