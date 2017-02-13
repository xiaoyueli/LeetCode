package facebook;

/**
 * 
 * @author xiaoyue
 * 
 * 给一个Pair (M, N) 代表坐标，你从(1, 1)出发，每次 (x, y) => (x + y, y) or (x, x + y)向右下方移动，如果能达到(M, N)就是True，反之False
 *
 */

public class _Path {
    
    public boolean solve(int[][] board, int x, int y) {
        
        while (x >= 1 && y >= 1) {
            if (x > y) {
                x -= y;
            }
            else y -= x;
            
            if (x == 1 && y == 1) return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
