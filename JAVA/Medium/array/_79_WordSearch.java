package array;

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
    
    int len;
    char[][] board;
    boolean[][] added;
    Character[] words;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        len = word.length();
        words = new Character[len];
        added = new boolean[board.length][board[0].length];
        for (int idx = 0; idx < len; idx++) {
            words[idx] = word.charAt(idx);
        }
        
        return find(0, 0, 0, 0);
    }
    
    public boolean find(int r, int c, int cnt, int level) {
        
        level++;
        for (int row = r; row < board.length; row++) {
            for (int col = c; col< board[row].length; col++) {
                int oriC = words[cnt];
                int newC = board[row][col];
                
                if (oriC == newC && !added[row][col]) {
                    cnt++;
                    added[row][col] = true;
                    if (cnt == len) return true;
                    if (col + 1 < board[row].length && !added[row][col + 1]) {
                        if (find(row, col + 1, cnt, level)) return true;
                    }
                    if (col - 1 >= 0 && !added[row][col - 1]) {
                        if (find(row, col - 1, cnt, level)) return true;
                    }
                    
                    if (row - 1 >= 0 && !added[row - 1][col]) {
                        if (find(row - 1, col, cnt, level)) return true;
                    }
                    
                    if (row + 1 < board.length && !added[row + 1][col]) {
                        if (find(row + 1 , col, cnt, level)) return true;
                    }
                    cnt--;
                    added[row][col] = false;
                    if (level != 1) return false;
                    
                }
                else if (level == 1) continue;
                else return false;
            }
        }
        
        return false;
    }
}
