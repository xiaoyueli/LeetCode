package dynamicProgramming;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall 
 * since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * 
 * Example:
 * For the given grid
 * 
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * 
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * 
 * 思路：
 * 遍历数组，
 * 每一cell，当col==0 和 或前一个cell是W时，计算本行E的数量直到遇到下一个W，如果没有遇到，则计算出的本区间的E的数量不需要更新
 * track 列时，用一个数组保存此列此区间E的数量。
 * 
 * 当当前cell的值为0时，更新横竖最大E的和。
 * 
 *
 */

public class _361_BombEnemy {
    
    public int maxKilledEnemies(char[][] grid) {
        
        int max = 0;
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        int[] cNums = new int[cols];
        
        for (int row = 0; row < rows; row++) {
            int rNum = 0;
            for (int col = 0; col < cols; col++) {
                
                if (col == 0 || grid[row][col - 1] == 'W') {
                    rNum = 0;
                    for (int i = col; i < cols && grid[row][i] != 'W'; i++) {
                        if (grid[row][i] == 'E') rNum++;
                    }
                }
                
                if (row == 0 || grid[row - 1][col] == 'W') {
                    cNums[col] = 0;
                    for (int j = row; j < rows && grid[j][col] != 'W'; j++) {
                        if (grid[j][col] == 'E') cNums[col]++;
                    }
                }
                
                if (grid[row][col] == '0') max = Math.max(max, rNum + cNums[col]);
            }
        }
        
        return max;
    }

}
