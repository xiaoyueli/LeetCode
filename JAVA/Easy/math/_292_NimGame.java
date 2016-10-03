package math;

/**
 * You are playing the following Nim Game with your friend: 
 * There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
 * The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * 
 * Both of you are very clever and have optimal strategies for the game. 
 * Write a function to determine whether you can win the game given the number of stones in the heap.
 * 
 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, 
 * the last stone will always be removed by your friend.
 * 
 * Hint:
 * If there are 5 stones in the heap, could you figure out a way to remove the stones such that you will always be the winner?
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 如果最后剩下4个，无论你怎么拿，最后都是对手拿最后一个石头
 * 因此对手只需要保证他拿完后剩下的数是4的倍数，那么你就不可能赢
 * 因此无论你拿1，2，3，对方只需要保证在最后一组4个石头前，根据你拿的情况拼4
 * 那么最后一组4一定是你先拿
 *
 */

public class _292_NimGame {
	
    public boolean canWinNim(int n) {
        
        return n % 4 != 0;  
    }

}
