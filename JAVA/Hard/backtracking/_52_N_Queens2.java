package backtracking;

/**
 * 
 * @author xiaoyue
 * 
 * Follow up for N-Queens problem.

    Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * 思路：
 * 用三个数组，cols 和两个对角线数组记录是否在该col和对角线上已经存在Q
 * 对角线数组的原理是，在同一反对角线上的cell的row + col相等， 在同一正对角线上cell的row - col相等，+n来处理负数问题
 */

public class _52_N_Queens2 {
    
    int count = 0;
    public int totalNQueens(int n) {
        
        boolean[] cols = new boolean[n];
        boolean[] dl = new boolean[2 * n];
        boolean[] dr = new boolean[2 * n];
        
        
        helper(0, cols, dl, dr, n);
        
        return count;
        
    }
    
    private void helper(int row, boolean[] cols, boolean[] dl, boolean[] dr, int n) {
        
        if (row == n) {
            count++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (cols[col] || dl[col - row + n] || dr[col + row]) continue;
            cols[col] = true;
            dl[col - row + n] = true;
            dr[col + row] = true;
            helper(row + 1, cols, dl, dr, n);
            cols[col] = false;
            dl[col - row + n] = false;
            dr[col + row] = false;
        }
    }

}
