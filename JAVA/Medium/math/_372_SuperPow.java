package math;

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer 
 * and b is an extremely large positive integer given in the form of an array.
 * 
 * Example1:
 * a = 2
 * b = [3]
 * Result: 8
 * 
 * Example2:
 * a = 2
 * b = [1,0]
 * Result: 1024
 * 
 * 原理：
 *  (a * b) % c == ((a % c) * (b % c)) % c;
 *  a^b mod c == b 个  a mod c 相乘
 *  例如 3^123 mod 5 == ((3^100 mod 5) * (3^20 mod 5) * (3^3 mod 5)) mod 5;
 *  
 *  3^100 mod 5 == 10个 3^10 mod 5相乘再 mod 5
 *  3^1000 mod 5 == 10个 3^100 mod 5 相乘再 mod 5
 *  
 *  二分法求mod
 *
 */

public class _372_SuperPow {
    
    public int superPow(int a, int[] b) {
        
        
        int len = b.length;
        if (len == 0) return 0;
        
        int res = 1;
        int base = a;

        for (int idx = len - 1; idx >= 0; idx--) {
            int val = b[idx];
            res *= powMod(base, val, 1337);
            res %= 1337;
            base = powMod(base, 10, 1337);
        }

        return res;
        
    }
    
    public int powMod(int base, int pow, int divisor) {
        int res = 1;
        base %= divisor;
        while (pow > 0) {
            if (pow % 2 == 1) res = (res * base) % divisor;
            pow /= 2;
            base = (base * base) % divisor;
        }
        return res;
    }
    
    public static void main(String[] args) {
        _372_SuperPow test = new _372_SuperPow();
        test.superPow(2147483647
                , new int []{2,0,0});
    }
}