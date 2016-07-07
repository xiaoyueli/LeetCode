package array;

public class _289_GameofLife {
    
    final int dd = 0;
    final int ll = 1;
    final int ld = 2;
    final int dl = 3;
    public void gameOfLife(int[][] board) {
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                update(row, col, board);
            }
        }
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ll || board[row][col] == dd) continue; 
                if (board[row][col] == dl) board[row][col] = ll;
                else board[row][col] = dd;
            }
        }
        
    }
    
    public void update(int row, int col, int[][] board) {
        int liveNei = 0;

        for (int neiR = row - 1; neiR <= row + 1; neiR++) {
            if (neiR < 0 || neiR >= board.length) continue;
            for (int neiC = col - 1; neiC <= col + 1; neiC++) {
                if (neiC < 0 || neiC >= board[neiR].length) continue;
                if (neiR == row && neiC == col) continue;
                if (board[neiR][neiC] == ll || board[neiR][neiC] == ld) liveNei++; 
            }
        }
        
        if (board[row][col] == ll || board[row][col] == ld) {
            if (liveNei < 2 || liveNei > 3) board[row][col] = ld;
        }
        else if (liveNei == 3) board[row][col] = dl;
    }
}
