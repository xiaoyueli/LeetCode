package unionFind;

/**
 * 
 * @author xiaoyue
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to find the number of connected components in an undirected graph.

    Example 1:
         0          3
         |          |
         1 --- 2    4
    Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
    
    Example 2:
         0           4
         |           |
         1 --- 2 --- 3
    Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
    
    Note:
    You can assume that no duplicate edges will appear in edges. 
    Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * 思路：
 * UnionFind, 用负数来保存group的大小
 */

public class _323_NumberofConnectedComponentsinanUndirectedGraph {
    
    public int countComponents(int n, int[][] edges) {
        
        int[] group = new int[n];
        for (int idx = 0; idx < n; idx++) group[idx] = -1;
        
        for (int[] edge: edges) {
            int p1 = edge[0];
            int p2 = edge[1];
            
            int root1 = findRoot(group, p1);
            int root2 = findRoot(group, p2);
            
            if (root1 != root2) {
                if (group[root1] < group[root2]) {
                    group[root1] += group[root2];
                    group[root2] = root1;
                }
                else {
                    group[root2] += group[root1];
                    group[root1] = root2;
                }
            }

        }
        
        int res = 0;
        for (int val: group) {
            if (val < 0) res++;
        }
        
        return res;
        
    }
    
    private int findRoot(int[] group, int p) {
        
        while (group[p] >= 0) p = group[p];
        
        return p;
    }

}
