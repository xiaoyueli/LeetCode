package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author xiaoyue
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.

    Example 1:
    
    11110
    11010
    11000
    00000
    Answer: 1
    
    Example 2:
    
    11000
    11000
    00100
    00011
    Answer: 3
 * 
 * 思路，
 * 遍历数组，遇到1时BFS，
 * 将等于1的邻居加入Q，并重设值为2.
 * 注意一定要在加入Q的时候设置为2，不能在出Q的时候设置
 */

public class _200_NumberofIslands {
    
    int height, width;
    public int numIslands(char[][] grid) {
        
        height = grid.length;
        if (height == 0) return 0;
        width = grid[0].length;
        int res = 0;
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] =='1') {
                    bfs(grid, row, col);
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private void bfs(char[][] grid, int row, int col) {
        
        grid[row][col] = '2';
        Queue<int[]> que = new LinkedList<int[]>();
        que.offer(new int[]{row, col});
        
        while (!que.isEmpty()) {
            int[] cell = que.poll();
            int r = cell[0];
            int c = cell[1];
            
            if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                que.offer(new int[]{r - 1, c});
                grid[r - 1][c] = '2';
            }
            if (r + 1 < height && grid[r + 1][c] == '1') {
                que.offer(new int[]{r + 1, c});
                grid[r + 1][c] = '2';
            }
            if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                que.offer(new int[]{r, c - 1});
                grid[r][c - 1] = '2';
            }
            if (c + 1 < width && grid[r][c + 1] == '1') {
                que.offer(new int[]{r, c + 1});
                grid[r][c + 1] = '2';
            }
        }
        
    }

}
