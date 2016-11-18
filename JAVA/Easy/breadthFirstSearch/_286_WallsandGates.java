package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author xiaoyue
 * 
 * You are given a m x n 2D grid initialized with these three possible values.

    -1 - A wall or an obstacle.
    0 - A gate.
    INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
    Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
    
    For example, given the 2D grid:
    INF  -1  0  INF
    INF INF INF  -1
    INF  -1 INF  -1
      0  -1 INF INF
    After running your function, the 2D grid should be:
      3  -1   0   1
      2   2   1  -1
      1  -1   2  -1
      0  -1   3   4
      
 * 题意：
 * 求到各个门的最短路径
 * 
 * 思路:
 * 遍历数组，遇到0时BFS。
 * BFS需建立优先队列加入符合条件的邻居
 * 符合条件的邻居：value不等于-1，不等于边界，val > 当前val + 1
 * 
 * 
 *      
 * 
 *
 */

public class _286_WallsandGates {
    
    int height;
    int width;
    public void wallsAndGates(int[][] rooms) {
        
        height = rooms.length;
        if (height == 0) return;
        width = rooms[0].length;

        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (rooms[row][col] == 0) bfs(rooms, row, col);
            }
        }
        
    }
    
    private void bfs(int[][] rooms, int row, int col) {

        Queue<int[]> que = new LinkedList<int[]>();
        
        que.offer(new int[]{row, col});
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            int val = rooms[r][c];
            if (r - 1 >= 0 && rooms[r - 1][c] != -1 && rooms[r - 1][c] > val + 1) {
                rooms[r - 1][c] = val + 1;
                que.offer(new int[]{r - 1, c});
            }
            
            if (r + 1 < height && rooms[r + 1][c] != -1 && rooms[r + 1][c] > val + 1) {
                rooms[r + 1][c] = val + 1;
                que.offer(new int[]{r + 1, c});
            }
            
            if (c - 1 >= 0 && rooms[r][c - 1] != -1 && rooms[r][c - 1] > val + 1) {
                rooms[r][c - 1] = val + 1;
                que.offer(new int[]{r, c - 1});
            }
            
            if (c + 1 < width && rooms[r][c + 1] != -1 && rooms[r][c + 1] > val + 1) {
                rooms[r][c + 1] = val + 1;
                que.offer(new int[]{r, c + 1});
            }
                
        }

    }

}
