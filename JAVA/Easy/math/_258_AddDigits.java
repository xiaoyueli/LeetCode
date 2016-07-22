package math;

/**
 * Given a non-negative integer num, 
 * repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 * 三位数abc = a * 100 + b * 10 + c
 *          = a + a * 99 + b + b * 9 + c
 *           = a + b + c + a * 99 + b * 9;
 * 
 *  abc % 9 == (a + b + c) % 9
 *  
 *  如果重复这个模式最后a + b + c == 9， 答案应该是9， 而不是0;
 *  为避免这种情况， 先将abc - 1 取模 9 在 + 1；
 *  即： ((abc - 1) + 1) % 9 == ((abc - 1) % 9 + 1 % 9) % 9;
 *  
 *  因为：
 *  如果VAL = A + B, 如果val % 9 != 0
 *  则，Val % 9 == (A % 9 + B % 9) % 9;
 *  
 *
 */

public class _258_AddDigits {
    
    public int addDigits(int num) {
        
        return (num - 1) % 9 + 1;
        
    }
}