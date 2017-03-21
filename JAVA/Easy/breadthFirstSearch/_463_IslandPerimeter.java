package breadthFirstSearch;

/**
 * 
 * @author xiaoyue
 * 
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
 * Grid cells are connected horizontally/vertically (not diagonally). 
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). 
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 
 * Determine the perimeter of the island.

    Example:
    
    [[0,1,0,0],
     [1,1,1,0],
     [0,1,0,0],
     [1,1,0,0]]
    
    Answer: 16
 */

public class _463_IslandPerimeter {
    
    public int islandPerimeter(int[][] grid) {
        
        int height = grid.length;
        int width = grid[0].length;
        
        int res = 0;
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 1) {
                    res = helper(grid, row, col);
                    return res;
                }
            }
        }
        
        return res;
    }
    
    private int helper(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) return 1;
        if (grid[row][col] == 0) return 1;
        if (grid[row][col] == -1) return 0;
        
        grid[row][col] = -1;
        
        int res = helper(grid, row - 1, col);
        res += helper(grid, row + 1, col);
        res += helper(grid, row, col - 1);
        res += helper(grid, row, col + 1);
        
        return res;
    }

}
