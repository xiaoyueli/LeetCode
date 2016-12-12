package backtracking;

/**
 * 
 * @author xiaoyue
 * 
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, 
 * you and your friend take turns to flip two consecutive "++" into "--". 
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.

    Write a function to determine if the starting player can guarantee a win.
    
    For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
    
    Follow up:
    Derive your algorithm's runtime complexity.
 * 思路：
 * 改变当前状态后，求下一个状态对少是否会赢，如果对手赢就还原当前状态， backtracking
 */

public class _294_FlipGame2 {
    
    public boolean canWin(String s) {

        char[] seq = s.toCharArray();
        for (int i = 0; i + 1 < seq.length; i++) {
            if (seq[i] == seq[i + 1] && seq[i] == '+') {
                seq[i] = '-';
                seq[i + 1] = '-';
                
                String next = new String(seq);
                if(!canWin(next)) return true;
                seq[i] = '+';
                seq[i + 1] = '+';
            }
        }
        
        return false;
         
    }
    

}
