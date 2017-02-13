package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), 
 * capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 *  X X X X
    X O O X
    X X O X
    X O X X
 * 
 * After running your function, the board should be:
 *  X X X X
    X X X X
    X X X X
    X O X X
    
       思路，标记边界O，替换成其他字符例如'-'
       从边界开始bfs 替换所有与'-'相连的'O'
   
      最后，
      将所有保留的'O'替换成'X'
       将所有'-' 还原成'O'
 */

public class _130_SurroundedRegions {
    
    public void solve(char[][] board) {
        
        int height = board.length;
        if (height == 0) return;
        int width = board[0].length;
        
        for (int i = 0; i < height; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][width - 1] == 'O') dfs(board, i, width - 1);
        }
        
        for (int i = 0; i < width; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[height - 1][i] == 'O') dfs(board, height - 1, i);
        }
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
        
    }
    
    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (board[row][col] != 'O') return;
        
        board[row][col] = '#';
        if (col + 1 != board[0].length - 1) dfs(board, row, col + 1); // board[0].length - 1 而不是board[0].length 只是为了减少递归的层数
        dfs(board, row, col - 1);
        dfs(board, row - 1, col);
        if (row + 1 != board.length - 1) dfs(board, row + 1, col);
        
    }

}
