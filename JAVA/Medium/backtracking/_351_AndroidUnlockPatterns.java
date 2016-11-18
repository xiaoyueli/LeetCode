package backtracking;

/**
 * @author xiaoyue
 * 
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, 
 * count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

    Rules for a valid pattern:
    Each pattern must connect at least m keys and at most n keys.
    All the keys must be distinct.
    If the line connecting two consecutive keys in the pattern passes through any other keys, 
    the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
    The order of keys used matters.
    
    Explanation:
    | 1 | 2 | 3 |
    | 4 | 5 | 6 |
    | 7 | 8 | 9 |
    Invalid move: 4 - 1 - 3 - 6 
    Line 1 - 3 passes through key 2 which had not been selected in the pattern.
    
    Invalid move: 4 - 1 - 9 - 2
    Line 1 - 9 passes through key 5 which had not been selected in the pattern.
    
    Valid move: 2 - 4 - 1 - 3 - 6
    Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
    
    Valid move: 6 - 5 - 4 - 1 - 9 - 2
    Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
    
    Example:
    Given m = 1, n = 1, return 9.
    
 * 题意，求解锁路径，要求路径长度大于m, 小于n，
 * 下一个数字要么紧挨着上一个数字，要么如果Jump其他数字，其他数字必须已经被选中。
 * 
 * 思路，建立10*10 2D数组，初始化各个数字到其他数字是否需要JUMP,
 * 在用一个10的1D数组，保存该数字是否被访问过。
 * 
 * backtracking的思路解
 * 只需要遍历3中模式，因为从1出发和从3，7，9出发的图形是对称的，得到答案后*4即可
 * 同理，2，4，6，8
 * 最后遍历5.
 * 
 *
 */

public class _351_AndroidUnlockPatterns {
    
    public int numberOfPatterns(int m, int n) {
        
        int[][] jumps = setJumps(10);
        boolean[] visited = new boolean[10];
        
        int res = 0;
        
        res += helper(jumps, visited, 1, 0, 1, m, n) * 4;
        res += helper(jumps, visited, 2, 0, 1, m, n) * 4;
        res += helper(jumps, visited, 5, 0, 1, m, n);
        
        return res;
    }
    
    private int helper(int[][] jumps, boolean[] visited, int num, int cnt, int len, int min, int max) {
        
        
        if (len >= min) cnt++;
        if (len == max) return cnt;
        
        visited[num]= true;
        
        for (int i = 1; i <= 9; i++) {
            int jump = jumps[num][i];
            if (!visited[i] && (jump == 0 || visited[jump])) {
                cnt = helper(jumps, visited, i, cnt, len + 1, min, max);
            }
        }
        visited[num] = false;
        
        return cnt;
    }
    
    private int[][] setJumps(int size) {
        int[][] grid = new int[size][size];
        grid[1][3] = 2;
        grid[1][7] = 4;
        grid[1][9] = 5;
        
        grid[3][1] = 2;
        grid[3][7] = 5;
        grid[3][9] = 6;
        
        grid[9][1] = 5;
        grid[9][3] = 6;
        grid[9][7] = 8;
        
        grid[7][1] = 4;
        grid[7][3] = 5;
        grid[7][9] = 8;
        
        grid[2][8] = 5;
        grid[8][2] = 5;
        grid[4][6] = 5;
        grid[6][4] = 5;
        
        return grid;
    }

}
