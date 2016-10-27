package bitManipulation;

/**
 * 
 * @author xiaoyue
 *
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * 思路：
 * 计算二进制每一位出现1的次数
 * 如果不能被3整除，说明只出现1次的那个数在该位有值，用res 异或一下
 */

public class _137_SingleNumber2 {
    
    public int singleNumber(int[] nums) {
        
        int res = 0;
        
        for (int idx = 0; idx < 32; idx++) {
            int check = 1 << idx;
            int cnt = 0;
            for (int num: nums) {
                if ((num & check) != 0) cnt++;
            }
            if (cnt % 3 != 0) res ^= check;
        }
        
        return res;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(1 << 2);
    }

}
