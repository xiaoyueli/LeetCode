package math;

/**
 * There are n bulbs that are initially off. 
 * You first turn on all the bulbs. Then, you turn off every second bulb. 
 * On the third round, you toggle every third bulb 
 * (turning on if it's off or turning off if it's on). 
 * For the ith round, you toggle every i bulb. 
 * For the nth round, you only toggle the last bulb. 
 * Find how many bulbs are on after n rounds.
 * 
 * Example:
 * Given n = 3. 
 * 
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off]. 
 * So you should return 1, because there is only one bulb is on.
 *
 *  每次从第N盏灯开始switch
 *  则第N盏灯会被SWITCH的次数==N的因子数（能整除N的数）
 *  例如，第6盏灯，会在第1,2,3,6次操作时被SWITCH
 *  最后亮着的灯一定是被操作了奇数次；
 *  而一个数的因子数一定是成对出现的
 *  只有平方数的因子会落单（两个相同因子）
 *  因此就是求小于等于N的平方数数量，即N的开方
 */

public class _319_BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
