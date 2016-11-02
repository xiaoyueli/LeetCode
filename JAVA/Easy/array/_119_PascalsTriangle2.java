package array;

import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangle2 {
    
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(1);
        int row = 0;
        
        while (row < rowIndex) {
            
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            int len = row + 1;
            
            for (int idx = 0; idx < len - 1; idx++) {
                cur.add(ls.get(idx) + ls.get(idx + 1));
            }
            
            cur.add(1);
            ls = cur;
            
            row++;
        }
        
        return ls;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
