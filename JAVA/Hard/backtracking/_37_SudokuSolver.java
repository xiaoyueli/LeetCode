package backtracking;

/**
 * 
 * @author xiaoyue
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
    
    Empty cells are indicated by the character '.'.
    
    You may assume that there will be only one unique solution.
        
    A sudoku puzzle...

 *
 */

public class _37_SudokuSolver {
    
    public void solveSudoku(char[][] board) {
        
        solve(board, 0);
        
    }
    
    private boolean solve(char[][] board, int pos) {
        if (pos == 81) return true;
        
        int row = pos / board.length;
        int col = pos % board[0].length;
        
        if (board[row][col] == '.') {
            for (char num = '1'; num <= '9'; num++) {
                if (check(board, row, col, num)) {
                    board[row][col] = num;
                    if (solve(board, pos + 1)) return true;
                    board[row][col] = '.';
                }
            }
            return false;
        }
        else return solve(board, pos + 1);
        
    }
    
    private boolean check(char[][] board, int row, int col, char num) {
        
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
        }
        
        row = row / 3 * 3;
        col = col / 3 * 3;
        
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        
        return true;
        
    }

}
