package math;

/**
 * You are given two jugs with capacities x and y litres. 
 * There is an infinite amount of water supply available. 
 * You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * 
 * If z liters of water is measurable, 
 * you must have z liters of water contained within one or both buckets by the end.
 * 
 * Operations allowed:
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full 
 * or the first jug itself is empty.
 * 
 * Example 1: (From the famous "Die Hard" example)
 * Input: x = 3, y = 5, z = 4
 * Output: True
 *
 * Example 2:
 * Input: x = 2, y = 6, z = 5
 * Output: False
 * 
 * 实质就是求最大公约数：
 * 最大公约数原理：如果两个数的最大公约数是k,则k也是他们余数的约数：
 * 原理一： (a + b) % c = (a % c + b % c) % c;
 * 设 A > B ， A % B == C, 且 A 和 B 有公约数 i
 * 即 : B * n + C == A 
 * -> (B * n + C) % i == A % i == 0
 * ->  (B * n) % i + C % i == A % i == 0
 * ->  C % i == 0 -> 余数C也能被i整除
 * 
 * 当有x, y 两个容量的桶时， x, y 的差值，也必定是他们公约数的倍数（差值  == 余数+ n - 1倍小桶的容量）
 * 这时，我们对两个桶的容量求余
 * 将余数看为新的更小的桶，原来的小桶看做新的大桶，又能得出新的差值，
 * （原来的小桶继续往原来的大桶倒水到满，剩下的就是差值的量）
 * 在某一次小桶的容量是余数的倍数时，余数就是最大公约数
 * 而每一次的差值也是这个公约数的倍数。
 * 
 *  因此。只要Z是最大公约数的倍数，并且小于X + Y 的总和。
 *  我们总能在一次求差中求得Z的值
 * 
 * 
 */

public class _365_WaterandJugProblem {
    
    public boolean canMeasureWater(int x, int y, int z) {
        
        if (z > x + y || z < 0) return false;
        if (z == 0) return true;
        if (x == 0 || y == 0) return x == z || y == z; 
        
        int biger = x;
        int smaller = y;
        
        if (y > x) {
            biger = y;
            smaller = x;
        }
        
        while (biger % smaller != 0) {
            int temp = smaller;
            smaller = biger % smaller;
            biger = temp;
        }
        
        if (z % smaller == 0) return true;
        return false;
        
    }
}