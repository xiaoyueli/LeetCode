package dynamicProgramming;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 * 1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 * 动态规划：
 * 当有n个结点时，总的树量为1..n的每一个数作根节点的树的总数之和
 * 而当k作根节点时，数的总量 == 左子树总数（小于k） * 右子树总数（大于k）
 * 算子不同子树个数时，只与结点数量有关
 * 例如，当n == 9，根结点 为 4，则我们需求，有3个结点的左子树，与有5个结点的右子树的乘积
 * 根结点为3时，则是2个结点的左子树与6个结点的右子树乘积
 * 然后遍历相加，得到有9个结点的树量，因此又能作为求n == 10的时候的子树数量
 * 
 * 
 */

public class _96_UniqueBinarySearchTrees {
    
    public int numTrees(int n) {
        
        int[] count = new int[n + 1];
        
        count[0] = 1;
        
        for (int num = 1; num <= n; num++) {
            
            for (int other = 1; other <= num; other++) {
                count[num] += count[other - 1] * count[num - other]; 
            }
        }
        
        return count[n];
        
    }

}
