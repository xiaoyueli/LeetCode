package zillow;

import java.util.ArrayList;

public class Heapify {
    
    public void heapify(int[] A) {
        // write your code here
        
        int len = A.length;
        
        for (int idx = len / 2; idx >= 0; idx--) {
            sink(A, idx, len);
        }
    }
    
    private void sink(int[] seq, int pos, int len) {
        int val = seq[pos];
        while (pos * 2 + 1 < len) {
            int son = pos * 2 + 1;
            int max = seq[son];
            if (son + 1 < len && seq[son] < seq[son + 1]) {
                max = seq[son + 1];
                son ++;
            }
            if (max > val) {
                seq[pos] = max;
                pos = son;
            }
            else break;
        }
        seq[pos] = val;
    }
    
    private void sort(int[] nums) {
        int last = nums.length - 1;
        
        while (last > 0) {
            swap(nums, last, 0);
            sink(nums, 0, last);
            last--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Heapify test = new Heapify();
        int[] nums = new int[]{3, 4, 6, 2, 1, 7, 5};
        test.heapify(nums);
        test.sort(nums);
        for (int i: nums) System.out.print(i + " ");

        
    }

}
