package array;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids.
 *  How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 *
 *  把有障碍物的格子设置为0，表示没有办法到达
 */

public class _63_UniquePaths2 {
    
    int[][] grid;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        grid = obstacleGrid;
        int height = grid.length;
        int width = grid[0].length;
        
        if (grid[0][0] == 1 || grid[height - 1][width - 1] == 1) return 0;
        grid[0][0] = 1;
        
        for (int col = 1; col < grid[0].length; col++) {
            if (grid[0][col] == 0) grid[0][col] += grid[0][col - 1];
            else grid[0][col] = 0;
        }
        
        for (int row = 1; row < grid.length; row++) {
            if (grid[row][0] == 0) grid[row][0] += grid[row - 1][0];
            else grid[row][0] = 0;
        }
        
        for (int row = 1; row < height; row++) {
            for (int col = 1; col < width; col++) {
                if (grid[row][col] == 1) grid[row][col] = 0;
                else grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
            }
        }
        
        return grid[height - 1][width - 1];
    }

}
