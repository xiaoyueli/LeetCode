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
    
    int height;
    int width;
    public void solve(char[][] board) {
        
        height = board.length;
        if (height == 0) return;
        width = board[0].length;
        
        for (int col = 0; col < width; col++) {
            if (board[0][col] == 'O') {
                board[0][col] = '-';
                bfs(board, 0, col);
            }
            if (board[height - 1][col] == 'O') {
                board[height - 1][col] = '-';
                bfs(board,height - 1, col);
            }
        }
        
        for (int row = 1; row < height - 1; row++) {
            if (board[row][0] == 'O') {
                board[row][0] = '-';
                bfs(board, row, 0);
            }
            if (board[row][width - 1] == 'O') {
                board[row][width - 1] = '-';
                bfs(board, row, width - 1);
            }
        }
        
        
        remarkBoard(board);
   
    }
    
    
    public void bfs(char[][] board, int row, int col) {
        
        Queue<Integer> que = new LinkedList<Integer>();
        int pos = row * width + col;
        que.offer(pos);
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            row = cur / width;
            col = cur % width;
            if (row - 1 >= 0 && board[row - 1][col] == 'O') enQue(board, que, row - 1, col);
            if (row + 1 < height && board[row + 1][col] == 'O') enQue(board, que, row + 1, col);
            if (col - 1 >= 0 && board[row][col - 1] == 'O') enQue(board, que, row, col - 1);
            if (col + 1 < width && board[row][col + 1] == 'O') enQue(board, que, row, col + 1);
        }
        
    }
    
    public void enQue(char[][] board, Queue<Integer> que, int row, int col) {
        board[row][col] = '-';
        int pos = row * width + col;
        que.offer(pos);
    }
    
    public void remarkBoard(char[][] board) {
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                char cur = board[row][col];
                if (cur == '-') board[row][col] = 'O';
                else if (cur == 'O') board[row][col] = 'X';
            }
        }
    }

}
