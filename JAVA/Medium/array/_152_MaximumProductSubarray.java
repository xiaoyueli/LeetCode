package array;
/**
 * 根据新乘入元素的正负号分情况处理
 */
public class _152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        
        for (int num: nums) {
            if (num > 0) {
                max *= num;
                min *= num;
                res = Math.max(max, res);
            }
            else if (num == 0) {
                max = 1;
                min = 1;
                res = Math.max(0, res);
            }
            else {
                res = Math.max(res, min * num);
                int temp = max;
                max = Math.max(1, min * num);
                min = temp * num;
            }
        }
        
        return res;
        
    }

}
