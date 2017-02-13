package unionFind;

/**
 * 
 * @author xiaoyue
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.

    For example:
    
    Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
    
    Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 * 思路：
 * unionFind check有没有环
 * 
 */

public class _261_GraphValidTree {
    
    public boolean validTree(int n, int[][] edges) {
        
        int[] unionfind = new int[n];
        for (int i = 0; i < n; i++) unionfind[i] = -1;
        
        for (int[] edge: edges) {
            if (isConnectedAndConnect(unionfind, edge[0], edge[1])) return false;
        }
        
        for (int num: unionfind) {
            if (num == -n) return true;
        }
        return false;
        
    }
    
    private boolean isConnectedAndConnect(int[] unif, int i, int j) {
        while (unif[i] >= 0) i = unif[i];
        while (unif[j] >= 0) j = unif[j];
        if (j == i) return true;
        if (unif[j] < unif[i]) {
            unif[j] += unif[i];
            unif[i] = j;
        }
        else {
            unif[i] += unif[j];
            unif[j] = i;
        }
        
        return false;
    }

}
