package hashtable;

/**
 *  point is how to map the subboxes,
 *  formula is : row / 3 (every three rows map to the same index ) * 3
 *              + col / 3 (every three column map to the same index) 
 *  array is faster than hashSet
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _36_ValidSudoku {
    
    public boolean isValidSudoku(char[][] board) {
        
        List<boolean[]> lr = new ArrayList<>();
        List<boolean[]> lc = new ArrayList<>();
        List<boolean[]> lb = new ArrayList<>();
        
        int len = board.length;
        for (int idx = 0; idx < len; idx++) {
            lr.add(new boolean[len]);
            lc.add(new boolean[len]);
            lb.add(new boolean[len]);
        }

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                char c = board[row][col];
                if (c != '.' && (lr.get(row)[c - '0' - 1] ||
                    lc.get(col)[c - '0' - 1] ||
                    lb.get(row / 3 * 3 + col / 3)[c - '0' - 1])) return false;
                
                if (c != '.') {
                    lr.get(row)[c - '0' - 1] = true;
                    lc.get(col)[c - '0' - 1] = true;
                    lb.get(row / 3 * 3 + col / 3)[c - '0' - 1] = true; 
                }      
            }
        }
        
        return true;
    }
    public boolean isValidSudoku2(char[][] board) {
        
        List<Set<Character>> lr = new ArrayList<>();
        List<Set<Character>> lc = new ArrayList<>();
        List<Set<Character>> lb = new ArrayList<>();
        
        int len = board.length;
        for (int idx = 0; idx < len; idx++) {
            lr.add(new HashSet<Character>());
            lc.add(new HashSet<Character>());
            lb.add(new HashSet<Character>());
        }
        
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                char c = board[row][col];
                if (c != '.' && (lr.get(row).contains(c) ||
                    lc.get(col).contains(c) ||
                    lb.get(row / 3 * 3 + col / 3).contains(c))) return false;
                
                lr.get(row).add(c);
                lc.get(col).add(c);
                lb.get(row / 3 * 3 + col / 3).add(c);
                    
            }
        }     
        return true;
    }
}
