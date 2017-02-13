package math;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * 排列组合，N的全排列中第K个元素
 * 排列组合性质：i 位数的 全排列个数 == i * i-1 位数的全排列个数
 * 例如 4位数的全排列个数 == 4 * 3位数的全排列个数
 * 例：1 2 3 4 
 *     1 2 4 3
 *     1 3 2 4
 *     1 3 4 2
 *     1 4 2 3
 *     1 4 3 2
 *     
 * 将相同首字母的组合看做同一层，对K求商则可知道K在第几层
 * 对K求余，则得到长度为N-1时，K是几个所求数字
 *
 */

public class _60_PermutationSequence {
    
    public String getPermutation(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        boolean[] added = new boolean[n];
        int total = getFactorial(n);
        
        int level = n;
        while (level != 1) {
            
            total = total / level; // n-1的全摆列
            
            int nth = (k - 1) / total + 1;  // 第n层是第几个chunk
            k = (k - 1) % total + 1;    // 下一层需找的第几个数
            
            int num = getNthNotUsed(n, nth, added);  // 获得第nth尚未被使用的数
            sb.append(num);
            
            level--;
        }
        
        sb.append(getNthNotUsed(n, 1, added));
        
        return sb.toString();
        
    }
    
    private int getFactorial(int n) {
        int res = 1;
        while (n > 1) res *= n--;

        return res;
    }
    
    private int getNthNotUsed(int n, int nth, boolean[] added) {
        
        for (int i = 1; i <= n; i++) {
            if (!added[i - 1]) nth--;
            if (nth == 0) {
                added[i - 1] = true;
                return i;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        _60_PermutationSequence test = new _60_PermutationSequence();
        test.getPermutation(8, 8590);
    }
}
