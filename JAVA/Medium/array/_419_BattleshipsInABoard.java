package array;

/**
 * @author xiaoyue
 * 
 * Given an 2D board, count how many different battleships are in it. 
 * The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * 
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, 
 * they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * 
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * 
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * 
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 * 
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 * 
 * 思路：
 * 遍历2D数组，用一个布尔变量检查是否遇到舰队，当当遇到舰队时，检查布尔变量为true, continue。
 * 其次检查当前舰队的上一行是不是舰队。
 *
 */

public class _419_BattleshipsInABoard {
    
    public int countBattleships(char[][] board) {
        
        int sum = 0;

        int rows = board.length;
        int cols = board[0].length;
        
        for (int row = 0; row < rows; row++) {
            boolean isBS = false;
            for (int col = 0; col < cols; col++) {
                char cur = board[row][col];
                
                if (cur == 'X') {
                    if (isBS) continue;
                    isBS = true;
                    if (row == 0 || row - 1 >=0 && board[row - 1][col] == '.') sum++;
                }
                else isBS = false;
            }
        }
        
        return sum;
    }

}
