package breadthFirstSearch;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), 
 * count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Answer: 1

 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Answer: 3
 *
 */

public class _200_NumberofIslands {
    int height;
    int width;
    public int numIslands(char[][] grid) {
        
        height = grid.length;
        if (height == 0) return 0;
        width = grid[0].length;
        
        int res = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == '0') continue;
                else {
                    res++;
                    bfs(grid, row, col);
                }
            }
        }
        return res;
    }
    
    public void bfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        
        if (row - 1 >= 0 && grid[row - 1][col] == '1') bfs(grid, row - 1, col);
        if (row + 1 < height && grid[row + 1][col] == '1') bfs(grid, row + 1, col);
        if (col - 1 >= 0 && grid[row][col - 1] == '1') bfs(grid, row, col - 1);
        if (col + 1 < width && grid[row][col + 1] == '1') bfs(grid, row, col + 1);
        
    }

}
