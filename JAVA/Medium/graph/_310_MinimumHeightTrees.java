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
        if (n <= 2) {
            for (int i = 0; i < n; i++) res.add(i);
            return res;
        }
        
        List<Integer>[] map = new List[n];
        for (int i = 0; i < n; i++) map[i] = new ArrayList<Integer>();
        
        for (int[] edge: edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        
        Queue<Integer> que = new LinkedList<Integer>();
        
        for (int i = 0; i < n; i++) {
            if (map[i].size() == 1) que.offer(i);
        }
        
        int size = que.size();

        int node = n;
        while (true) {
            Integer cur = que.poll();
            node--;
            size--;
            List<Integer> ls = map[cur];
            for (Integer num: ls) {
                map[num].remove(cur);
                if (map[num].size() == 1) que.offer(num);
            }
            if (size == 0) {
                if (que.size() <= 2 && node <= 2) break;
                size = que.size();
            }
        }
        
        res.addAll(que);
        return res;
        
    }
}
