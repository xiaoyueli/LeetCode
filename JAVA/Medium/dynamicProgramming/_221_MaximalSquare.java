package dynamicProgramming;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Return 4.
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 用max记录当前有效最大边长
 * 依次扫描每一行记录当前累计的1的数量
 * 当前累计的1的数量大于max,从当前格子往上check有效边长（是否构成正方形）
 * 
 * check的时候注意记录当前有效最小值
 * 
 *
 */

public class _221_MaximalSquare {
    
    public int maximalSquare(char[][] matrix) {
        
        int height = matrix.length;
        if (height == 0) return 0;
        int width = matrix[0].length;
        
        int[][] dp = new int[height][width];
          
        int max = 0;
        for (int row = 0; row < height; row++) {
            int cnt = 0;
            for (int col = 0; col < width; col++) {
                char val = matrix[row][col];
                if (val == '1') cnt++;
                else cnt = 0;
                dp[row][col] = cnt;
                if (cnt > max) {
                    int valid = check(dp, row, col);
                    if (valid > max) max = valid;    
                }
                
            }
        }
        
        return max * max;
    }
    
    private int check(int[][] dp, int row, int col) {

        if (row == 0) return 1;
        int min = dp[row][col];
        row--;
        int cnt = 1; // 初始格子为有效格子
        while (row >=0 && dp[row][col] != 0) {

            min = Math.min(min, dp[row][col]); // 当前格子的长度如果比目前为止最短长度短，更新最短长度
            if (min <= cnt) break; // 如果当前格子的长度短于上一个格子累计的有效正方形边长则退出，否则有效正方形长度+1，格子再往上移动
            cnt++;
            row--;
        }
        
        return cnt;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       

    }

}
