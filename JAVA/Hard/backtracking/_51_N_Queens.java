package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement, 
    where 'Q' and '.' both indicate a queen and an empty space respectively.
    
    For example,
    There exist two distinct solutions to the 4-queens puzzle:
    
    [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],
    
     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
 * 
 * 思路：
 * 一行一行的在不同的col放Q，check valid
 * valid只需确认，当前行往上
 */

public class _51_N_Queens {
    
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> res = new ArrayList<>();
        List<String> ls = new ArrayList<String>();
        char[][] seq = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) seq[i][j] = '.';
        }
        
        helper(res, ls, seq);
        
        return res;
        
    }
    
    private void helper(List<List<String>> res, List<String> ls, char[][] seq) {
        if (ls.size() == seq.length) {
            res.add(new ArrayList<String>(ls));
            return;
        }
        
        int row = ls.size();
        for (int col = 0; col < seq.length; col++) {
            
            if (row != 0 && !isValid(seq, row, col)) continue;
            seq[row][col] = 'Q';
            ls.add(new String(seq[row]));
            helper(res, ls, seq);
            ls.remove(ls.size() - 1);
            seq[row][col] = '.';
        }
    }
    
    private boolean isValid(char[][] seq, int row, int col) {
        int ldig = col - 1;
        int rdig = col + 1;
        
        for (int i = row - 1; i >= 0; i--) {
            if (seq[i][col] == 'Q' || ldig >= 0 && seq[i][ldig] == 'Q' || rdig < seq.length && seq[i][rdig] == 'Q') return false;
            ldig--;
            rdig++;
        }
        return true;
    }

}
