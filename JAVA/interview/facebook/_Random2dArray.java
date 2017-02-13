package facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @author xiaoyue
 * 
 * reservoir sampling的题目
 * 
 * windows里面的扫雷, 生成一个高度h，宽度w，总共m颗雷的矩阵。要求m颗雷随机分布。
 *
 */

public class _Random2dArray {
    
    
    // O(h*w)
    public int[][] solve(int h, int w, int m) {
        
        int[] pos = new int[m];
        
        int i = 0;
        for (; i < m; i++) {
            pos[i] = i;
        }
        
        i++;
        Random rand = new Random();
        int len = h * w;
        for (; i <= len; i++) {
            int idx = rand.nextInt(i);
            if (idx < m) pos[idx] = i - 1;
        }
        
        int[][] board = new int[h][w];
        
        for (i = 0; i < m; i++) {
            int val = pos[i];
            int row = val / w;
            int col = val % w;
            board[row][col] = 1;
        }
        
        return board;
    }
    
    public int[][] solve2(int h, int w, int m) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = h * w;
        int[] res = new int[m];
        int idx = 0;
        
        Random rand = new Random();
        while (m > 0) {
            int pos = rand.nextInt(len);
            if (map.containsKey(pos)) res[idx++] = map.get(pos);
            else res[idx++] = pos;
            map.put(pos, len - 1);
            len--;
            m--;
        }
        
        int[][] board = new int[h][w];
        
        for (int i = 0; i < m; i++) {
            int val = res[i];
            int row = val / w;
            int col = val % w;
            board[row][col] = 1;
        }
        
        return board;
        
    }
    
}
