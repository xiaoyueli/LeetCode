package array;

public class _189_RotateArray {
    
    public void rotate(int[] nums, int k) {
        
        // METHOD_1
        // int n = nums.length;
        // if (n <= 1) return; 
        // int[] alt = new int[n];
        // for (int idx = 0; idx < n; idx++) {
        //     if (idx + k < n) alt[idx + k] = nums[idx];
        //     else {
        //         int pos = idx + k;
        //         while (pos >= n) {
        //             pos -= n;
        //         }
        //         alt[pos] = nums[idx];
        //     }
        // }
        
        // for (int idx = 0; idx < n; idx++) {
        //     nums[idx] = alt[idx];
        // }
        
        
        // METHOD_2, in place
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for (int idx = 0; idx < n ; idx++) {
            if (!visited[idx]) {
                rotate(idx, k, nums, visited);
            }
        }
    }
    
    public void rotate(int pos, int k, int[] nums, boolean[] visited) {
        int length = visited.length;
        int alt = nums[pos];
        while (!visited[pos]) {
            visited[pos] = true;
            if (pos + k < length) {
                int temp = nums[pos + k];
                nums[pos + k] = alt;
                alt = temp;
                pos = pos + k;
            }
            else {
                int next = pos + k - length;
                while (next >= length) next -= length;
                int temp = nums[next];
                nums[next] = alt;
                alt = temp;
                pos = next;
            }
        }
    }   
}
