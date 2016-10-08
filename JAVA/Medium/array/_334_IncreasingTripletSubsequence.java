package array;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * 
 * Formally the function should:
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * 
 * Given [5, 4, 3, 2, 1],
 * return false.
 * 
 * @author xiaoyue
 *
 */

public class _334_IncreasingTripletSubsequence {
	
    public boolean increasingTriplet(int[] nums) {
        
        int len = nums.length;
        if (len < 3) return false;
        
        int fir = nums[0];
        int sec = Integer.MAX_VALUE;
        for (int idx = 1; idx < len; idx++) {
            int val = nums[idx];
            if (val > sec) return true;
            if (val <= fir) fir = val;
            else sec = val;
        }
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
