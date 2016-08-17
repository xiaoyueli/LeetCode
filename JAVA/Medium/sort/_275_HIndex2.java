package sort;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? 
 * Could you optimize your algorithm?
 * 
 * 若有n个数组值至少大于n，求这个最大n值
 * 例如有三个数的值至少都大于三， 3为所求
 *
 */

public class _275_HIndex2 {
    
    public int hIndex(int[] citations) {
        
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        int num = 0;
        int val = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            val = citations[mid];
            num = len - mid;
            if (val == num) return num;
            if (num < val) right = mid - 1;
            else left = mid + 1;
        }
        
        if (num == val) return 0;
        if (num < val) return num;
        return num - 1;
        
    }

}
