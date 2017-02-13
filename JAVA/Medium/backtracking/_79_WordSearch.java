package backtracking;

/**
 * Given a 2D board and a word, 
 * find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * For example,
 * Given board =
 *[
 *  ['A','B','C','E'],
 *  ['S','F','C','S'],
 *  ['A','D','E','E']
 *]
 *
 * 回溯法
 */

public class _79_WordSearch {
    
    public boolean exist(char[][] board, String word) {
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0)) return true;
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, String word, int row, int col, int pos) {
        if (pos == word.length()) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        
        if (board[row][col] == word.charAt(pos)) {
            board[row][col] = '#';
            if (helper(board, word, row + 1, col, pos + 1)) return true;
            if (helper(board, word, row - 1, col, pos + 1)) return true;
            if (helper(board, word, row, col + 1, pos + 1)) return true;
            if (helper(board, word, row, col - 1, pos + 1)) return true;
            board[row][col] = word.charAt(pos);
        }    
        
        return false;
    }
}
