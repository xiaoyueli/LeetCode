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
        boolean[] used = new boolean[n + 1];
        int level = n;
        while (level > 1) {
            
            int countPer = level - 1;
            int next = countPer - 1;
            while (next != 0) {
                // 当第N位是相同字母时，有N-1种排列
                countPer *= next;
                next--;
            }
            
            int rema = (k - 1) % countPer + 1;
            int digit = (k - rema) / countPer + 1;  // k在第几层当中
            
            for (int num = 1; num <= n; num++) {
                // 第digit个字母则是该位所需的数字
                
                if (!used[num]) {
                    digit--;
                    if (digit == 0) {
                        sb.append(num);
                        used[num] = true;
                        break;
                    }
                }
            }
            
            level--;
            k = rema; // 余数等于k在下一层的第几个
            
        }
        
        for (int num = 1; num <= n; num++) {
            if (!used[num]) {
                sb.append(num);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        _60_PermutationSequence test = new _60_PermutationSequence();
        test.getPermutation(8, 8590);
    }
}
