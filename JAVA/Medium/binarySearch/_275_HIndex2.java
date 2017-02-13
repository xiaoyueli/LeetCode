package binarySearch;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? 
 * Could you optimize your algorithm?
 * 
 * 思路：
 * Hindex 即有n本书的idx大于等于n
 * 
 * 则当某一个element的值大于剩余的array长度，则表示之后的element都大于这个值。
 * 当剩余的长度 正好等于当前element时，即为所求，因为往前一个元素，值减小，而长度增大。不能做到值大于长度，往后一个元素，长度减小，不能做到最优解（最大Hidx）
 * 
 * 当剩余长度 < element 增加剩余长度，求更大的值， right 减小
 * 反之 left 增加
 * 
 * 返回 length - left.
 * 
 *
 */

public class _275_HIndex2 {
    
    public int hIndex(int[] citations) {
        
        int length = citations.length;
        int left = 0;
        int right = length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (citations[mid] == length - mid) return length - mid;
            else if (citations[mid] > length - mid) right = mid - 1;
            else left = mid + 1;
        }
        
        return length - left;
    }

}
