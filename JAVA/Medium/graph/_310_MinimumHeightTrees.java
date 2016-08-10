package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * For a undirected graph with tree characteristics, 
 * we can choose any node as the root. 
 * The result graph is then a rooted tree. 
 * Among all possible rooted trees, 
 * those with minimum height are called minimum height trees (MHTs). 
 * Given such a graph, 
 * write a function to find all the MHTs and return a list of their root labels.
 * 
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. 
 * You will be given the number n and a list of undirected edges 
 * (each edge is a pair of labels).
 * 
 * You can assume that no duplicate edges will appear in edges. 
 * Since all edges are undirected, 
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * 
 * Example 1:
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *      0
        |
        1
       / \
      2   3
 * 
 * return [1]
 * 
 * Example 2:
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 *   0  1  2
      \ | /
        3
        |
        4
        |
        5
        
 * return [3, 4]
 * 
 * 
 * 方法一，算出叶子结点，加入队列，一层一层的将叶子结点删除
 */

public class _310_MinimumHeightTrees {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (n == 1) {
            res.add(0);
            return res;
        }
        else if (n == 2) {
            res.add(0);
            res.add(1);
            return res;
        } 
        
        List<List<Integer>> gra = new ArrayList<>();
        
        for (int idx = 0; idx < n; idx++) gra.add(new ArrayList<Integer>());
        
        for (int[] edge: edges) {
            gra.get(edge[0]).add(edge[1]);
            gra.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> que = new LinkedList<Integer>();
        
        for (int idx = 0; idx < n; idx++) {
            if (gra.get(idx).size() == 1) que.offer(idx);
        }

        int size = que.size();
        Set<Integer> set = new HashSet<Integer>();
        
        while (!que.isEmpty()) {
            int ver = que.poll();
            size--;
            set.add(ver);
            int other = gra.get(ver).get(0);
            List<Integer> tos = gra.get(other);
            tos.remove(new Integer(ver));
            if (tos.size() == 1) que.offer(other);
            
            if (size == 0) {
                size = que.size();
                if (size == 2 && set.size() + 2 == n) break;
                if (size == 1 && set.size() + 1 == n) break;
            }
        }

        while (!que.isEmpty()) res.add(que.poll());
        
        return res;
        
    }
}
