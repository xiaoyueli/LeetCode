package facebook;

/**
 * 
 * @author xiaoyue
 * 
 * We're given a sorted array of integers: [-3, -1, 0, 1, 2]. 
 * We want to generate a sorted array of their squares: [0, 1, 1, 4, 9]
 *
 */

public class _SequenceOfSquares {
    
    public int[] solve(int[] nums) {
        
        int[] res = new int[nums.length];
        
        int left = 0;
        int right = nums.length - 1;
        int lo = 0;
        int hi = right;
        
        while (left <= right) {
            if (nums[left] < 0) {
                int pl = nums[left] * nums[left];
                int pr = nums[right] * nums[right];
                if (pl < pr) {
                    res[hi--] = pr;
                    right--;
                }
                else {
                    res[hi--] = pl;
                    left++;
                }
            }
            else {
                res[lo++] = nums[left] * nums[left];
                left++;
            }
        }
        
        return res;
    }
    
    public int[] solve1(int[] nums) {
        
        int[] res = new int[nums.length];
        
        int left = 0;
        int right = nums.length - 1;
        int idx = right;
        
        while (left <= right) {
            int pl = nums[left] * nums[left];
            int pr = nums[right] * nums[right];
            if (pl > pr) {
                res[idx--] = pl;
                left++;
            }
            else {
                res[idx--] = pr;
                right--;
            }
            
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        int[] nums = new int[]{-7, -3, -2, 0, 1, 3, 5, 8};
        _SequenceOfSquares test = new _SequenceOfSquares();
        
        int[] res = test.solve1(nums);
        
        for (int i : res) System.out.print(i + " ");
        
    }

}
