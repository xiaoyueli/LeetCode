package bitManipulation;

/**
 * 
 * @author xiaoyue
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Now your job is to find the total Hamming distance between all pairs of the given numbers.
    
    Example:
    Input: 4, 14, 2
    
    Output: 6
    
    Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
    showing the four bits relevant in this case). So the answer will be:
    HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
    Note:
    Elements of the given array are in the range of 0 to 10^9
    Length of the array will not exceed 10^4.
 * 
 * 
 * 思路：
 * 因为是求所有pairs，所以要求得数量级就是所有的combination.
 * 那么可以转换为对每一bit位求可能的组合。
 * 即，计算出每一bit位有多少数在该位为1，假设为K个，那么n-k个数不为1。那么这么数两两组合能产生1的数量即为k * (n - k)
 */

public class _477_TotalHammingDistance {
    
    public int totalHammingDistance(int[] nums) {
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            
            int cnt = 0;
            for (int num: nums) cnt += (num >> i) & 1;
            
            res += (nums.length - cnt) * cnt;
        }
        
        return res;
    }

}
