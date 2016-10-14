package deepFirstSearch;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * 
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 * 
 * Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic
  
  Return:
  [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 *
 * 题目求得是经过某点，同时有水流能流向两大洋
 * 思路：
 * 建立2个 2D数组分别DFS能流向两大洋的点，各自从边界开始遍历，周围的点高于边界的设置为TURE
 * 最后在遍历比较 两个数组都是TRUE的点加入LIST
 */

import java.util.ArrayList;
import java.util.List;

public class _417_PacificAtlanticWaterFlow {
    
    int height;
    int width;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        
        List<int[]> res = new ArrayList<int[]>();
        height = matrix.length;
        if (height == 0 || matrix == null) return res;
        width = matrix[0].length;
        
        boolean[][] toPac = new boolean[height][width];
        boolean[][] toAtl = new boolean[height][width];
        
        checkAccess(toPac, matrix, 0, 0);
        checkAccess(toAtl, matrix, height - 1, width - 1);
        
        
        for (int irow = 0; irow < height; irow++) {
            for (int icol = 0; icol < width; icol++) {
                if (toPac[irow][icol] && toAtl[irow][icol]) res.add(new int[]{irow, icol});
            }
        }

        return res;
    }
    
    private void checkAccess(boolean[][] isAccessed, int[][] table, int row, int col) {
        
        boolean[][] isVisited = new boolean[height][width];
        
        for (int irow = 0; irow < height; irow++) {
            isAccessed[irow][col] = true;
            if (isVisited[irow][col]) continue;
            dfs(isAccessed, isVisited, table, irow, col);
        }
        
        for (int icol = 0; icol < width; icol++) {
            isAccessed[row][icol] = true;
            if (isVisited[row][icol]) continue;
            dfs(isAccessed, isVisited, table, row, icol);
        }
        
    }
    
    
    private void dfs(boolean[][] isAccessed, boolean[][] isVisited, int[][] table, int r, int c) {
        
        isVisited[r][c] = true;
        
        if (r - 1 >= 0 && table[r][c] <= table[r - 1][c]) {

            isAccessed[r - 1][c] = true;
            if (isAccessed[r - 1][c] && !isVisited[r - 1][c]) dfs(isAccessed, isVisited, table, r - 1, c);
        }
        
        if (r + 1 < height && table[r][c] <= table[r + 1][c]) {

            isAccessed[r + 1][c] = true;
            if (isAccessed[r + 1][c] && !isVisited[r + 1][c]) dfs(isAccessed, isVisited, table, r + 1, c);
        }
        
        if (c - 1 >= 0 && table[r][c] <= table[r][c - 1]) {

            isAccessed[r][c - 1] = true;
            if (isAccessed[r][c - 1] && !isVisited[r][c - 1]) dfs(isAccessed, isVisited, table, r, c - 1);
        }
        
        if (c + 1 < width && table[r][c] <= table[r][c + 1]) {

            isAccessed[r][c + 1] = true;
            if (!isVisited[r][c + 1]) dfs(isAccessed, isVisited, table, r , c + 1);
        }
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _417_PacificAtlanticWaterFlow test = new _417_PacificAtlanticWaterFlow();
        
        int[][] info = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        test.pacificAtlantic(info);
        

    }

}
