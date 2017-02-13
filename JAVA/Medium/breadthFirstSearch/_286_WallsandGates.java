package breadthFirstSearch;

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
 *
 */

public class _286_WallsandGates {
    
    public void wallsAndGates(int[][] rooms) {
        
        int height = rooms.length;
        if (height == 0) return;
        int width = rooms[0].length;
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (rooms[row][col] == 0) search(rooms, row, col, 0);
            }
        }
        
    }
    
    private void search(int[][] rooms, int row, int col, int dis) {
        if (row < 0 || col < 0 || row >= rooms.length || col >= rooms[0].length) return;
        if (rooms[row][col] <= dis && dis != 0) return;
        
        rooms[row][col] = dis;
        
        search(rooms, row + 1, col, dis + 1);
        search(rooms, row - 1, col, dis + 1);
        search(rooms, row, col + 1, dis + 1);
        search(rooms, row, col - 1, dis + 1);
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
