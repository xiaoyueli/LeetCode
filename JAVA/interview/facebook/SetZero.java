package facebook;

import java.util.ArrayList;
import java.util.List;

public class SetZero {
    
    public void solve(int[][] nums, int k) {
        
        boolean[][] visited = new boolean[nums.length][nums[0].length];
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (!visited[i][j]) {
                    List<int[]> pairs = new ArrayList<int[]>();
                    int cnt = check(nums, visited, i, j, 0, pairs);
                    if (cnt < k) setZero(nums, pairs);
                }
            }
        }
    }
    
    private int check(int[][] nums, boolean[][] visited, int row, int col, int cnt, List<int[]> pairs) {
        
        visited[row][col] = true;
        if (nums[row][col] == 0) return cnt;
        pairs.add(new int[]{row, col});
        cnt++;
        if (row - 1 >= 0 && !visited[row - 1][col]) cnt = check(nums, visited, row - 1, col, cnt, pairs);
        if (row + 1 < nums.length && !visited[row + 1][col]) cnt = check(nums, visited, row + 1, col, cnt, pairs);
        if (col - 1 >= 0 && !visited[row][col - 1]) cnt = check(nums, visited, row, col - 1, cnt, pairs);
        if (col + 1 < nums[0].length && !visited[row][col + 1]) cnt = check(nums, visited, row, col + 1, cnt, pairs);
        if (row - 1 >= 0 && col - 1 >= 0 && !visited[row - 1][col - 1]) cnt = check(nums, visited, row - 1, col - 1, cnt, pairs);
        if (row - 1 >= 0 && col + 1 < nums[0].length && !visited[row - 1][col + 1]) cnt = check(nums, visited, row - 1, col + 1, cnt, pairs);
        if (row + 1 < nums.length && col - 1 >= 0 && !visited[row + 1][col - 1]) cnt = check(nums, visited, row + 1, col - 1, cnt, pairs);
        if (row + 1 < nums.length && col + 1 < nums[0].length && !visited[row + 1][col + 1]) cnt = check(nums, visited, row + 1, col + 1, cnt, pairs);
        
        return cnt;
    }
    
    private void setZero(int[][] nums, List<int[]> pairs) {
        for (int[] pos: pairs) {
            nums[pos[0]][pos[1]] = 0;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[][] nums = new int[][] {{1,1,0,1,1,0},
                                    {0,1,1,0,0,0},
                                    {0,0,0,0,1,1},
                                    {1,1,0,1,0,0},
                                    {0,1,0,0,0,1}};
                               
        SetZero test = new SetZero();
        test.solve(nums, 4);
        
        for (int[] arr: nums) {
            for (int i: arr) System.out.print(i + " ");
            System.out.println();
        }
    }

}
