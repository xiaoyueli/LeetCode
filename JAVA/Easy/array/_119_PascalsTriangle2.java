package array;

import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangle2 {
    
    public List<Integer> getRow(int rowIndex) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if (rowIndex == 0) {
            return list;
        }
        int row = 1;
        while (row <= rowIndex) {
            List<Integer> pre = list;
            list = new ArrayList<Integer>();
            list.add(1);
            for (int idx = 1; idx < row; idx++) {
                list.add(pre.get(idx - 1) + pre.get(idx));
            }
            list.add(1);
            row++;
        }
        return list;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
