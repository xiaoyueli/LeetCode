package math;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 * 用二进制原理，左移一位扩大两倍
 * 让除数不断左移直到大于被除数
 * 扩大的有效倍数则为商
 * 
 * 细节：
 * 当除数大于被除数后，扩大的有效倍数需回移1位
 * 有效除数回移一位，用被除数减去扩大的有效除数，
 * 剩下的值作为被除数循环
 * 直到剩余值小于除数
 * 
 * 例如： 22 / 4
 * res = 1;
 * 4 >> 1 == 8 >> 1 == 16 >> 1 == 32     16 < 22 < 32
 * 1 >> 1 == 2(扩大2倍) >> 1 == 4 >> 1 == 8    
 * 扩大4倍不足22， 扩大8倍超过22， 16 -> 22 还相差至少1个4
 * 
 * 32 << 1 == 16  -> 22 - 16 == 6
 * 6作为被除数重新循环，因为  (A + B) / C == A / C + B / C
 *  直到剩余的数小于4
 */

public class _29_DivideTwoIntegers {
    
    public int divide(int dividend, int divisor) {
        
        // 防止溢出
        long dend = dividend;
        long sor = divisor;
        
        boolean flag = true;
        if (dend * sor < 0) flag = false;
        
        if (dend < 0) dend = -dend;
        if (sor < 0) sor = -sor;
        
        long res = 0;
        long remaining = dend; // 初始化被除数
        
        while (remaining >= sor) {
            // 若左移一位，即当前除数扩大2倍后大于被除数
            // 则将当前除数缩小，用初始被除数与缩小后的除数的差值继续循环
            // 直到当前被除数小于原始除数
            
            long subremain = remaining;
            long curSor = sor; // 初始化除数
            long temp = 1;
            while (curSor <= subremain) {
                curSor <<= 1; // 除数左移1位，扩大2倍
                temp <<= 1;   // 倍数左右一位，扩大2倍
            }
            
            res += temp >> 1; // 有效倍数
            subremain = curSor >> 1; // 有效被除数
            remaining -= subremain; // 新一轮的被除数 = 本轮被除数 - 有效被除数
        }
        
        if (!flag) res = -res;
        
        if (res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        
        return (int)res;
        
    }
}
