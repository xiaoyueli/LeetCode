package facebook;

/**
 * 
 * @author xiaoyue
 * 
 * Define amazing number as: its value is less than or equal to its index. 
 * Given a circular array, find the starting position, such that the total number of amazing numbers in the array is maximized.
    
    Example 1: 0, 1, 2, 3
    Output: 0.
        
    When starting point at position 0, all the elements in the array are equal to its index. So all the numbers are amazing number.
    
    Example 2: 1, 0 , 0. 
    Output: 1.
        
    When starting point at position 1, the array becomes 0, 0, 1. 
    All the elements are amazing number.. more info on 1point3acres.com
    If there are multiple positions, return the smallest one.
 **
 ** 思路：
 ** amazing number is the value is less than or equal to its index
 ** 用一个count 数组，记录每一个index作为起始点时有多少amazing number.
 *  遍历数组，check 每一个数，如果该数大于等于array 的长度，说明无论如何它都不可能小于index，skip it
 *  如果该数小于0，则效果和0一样。说明无论从哪开始，它都是amazing number.
 *  否则， 该数作为amazing number的情况则是它的index 大于等于自身，小于数组长度；
 *  然后再用当前左边减去每一种可能的情况，则表示当前的起始点0应该向左或向右移动多少。然后count数组在新产生的起始点上+1
 **
 */

public class _AmazingNumbers {
    
    public int solve(int[] nums) {
        
        int len = nums.length;
        
        int[] count = new int[len];
        
        int max = 0;
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            if (val < 0) val = 0;
            for (int j = val; j < len; j++) {
                if (i - j >= 0) {
                    count[i - j]++;
                    if (count[i - j] > max) max = count[i - j];
                }
                else {
                    count[i - j + len]++;
                    if (count[i - j + len] > max) max = count[i - j + len];
                }
                
            }
        }
        
        for (int i = 0; i < len; i++) if (count[i] == max) return i;
        
        return -1;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _AmazingNumbers test = new _AmazingNumbers();
        int[] nums = new int[]{0 , -1, 2, 3};
        System.out.println(test.solve(nums));

    }

}
