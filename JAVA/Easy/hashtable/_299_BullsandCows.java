package hashtable;

/**
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * 
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, 
 * use A to indicate the bulls and B to indicate the cows. 
 * In the above example, your function should return "1A3B"
 * 
 * Please note that both secret number and friend's guess may contain duplicate digits, 
 * for example:
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, 
 * the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 * 
 * 在相同位子遇到相同数字，bull++
 * 否则，count该位子的数字
 */
public class _299_BullsandCows {
    public String getHint(String secret, String guess) {
        
        int[] sec = new int[10];
        int[] gue = new int[10];
        
        int bulls = 0;
        for (int idx = 0; idx < secret.length(); idx++) {

            if (secret.charAt(idx) == guess.charAt(idx)) bulls++;
            else {
                sec[secret.charAt(idx) - '0']++;
                gue[guess.charAt(idx) - '0']++;
            }
        }
        
        int cow = 0;
        for (int idx = 0; idx < 10; idx++) {
            cow += Math.min(sec[idx], gue[idx]);
        }
        return bulls + "A" + cow + "B";
    }
}
