package bitManipulation;

/**
 * 
 * @author xiaoyue
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
 * Find the two elements that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * 
 * 思路：
 * 用0异或一遍数组，等到的值即为 a^b;
 * a ^ b 的特点为，a/b二进制相同的位为0，不同的为1
 * 因此找到其中不同的一位，
 * 然后后遍历数组，用该不同的一位 与运算 数组元素，把数组分为该位为1和该位为0的两组
 * 最后的答案即为a , b
 *
 */

public class _260_SingleNumber3 {
    
    public int[] singleNumber(int[] nums) {
        
        int aXorb = 0;
        for (int num: nums) aXorb ^= num;
        

        int mark = 1;
        while ((aXorb & mark) == 0) mark <<= 1;
        
        int a = 0;
        int b = 0;
        for (int num: nums) {
            if ((num & mark) == 0) a ^= num;
            else b ^= num;
        }
        
        return new int[]{a, b};
    }

}
