package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Clone an undirected graph. 
 * Each node in the graph contains a label and a list of its neighbors.
 * 
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , 
 * as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, 
 * and therefore contains three parts as separated by #.
 *  First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 *  Second node is labeled as 1. Connect node 1 to node 2.
 *  Third node is labeled as 2. Connect node 2 to node 2 (itself), 
 *  thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * 
 *     1
      / \
     /   \
    0 --- 2
         / \
         \_/
 *
 *  
 *  复制图，HashMap + DFS/BFS
 *
 * Definition for undirected graph.
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};


public class _133_CloneGraph {

    // DFS
    HashMap<Integer, UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if (node == null) return null;
        
        Queue<UndirectedGraphNode> que = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map = new HashMap<Integer, UndirectedGraphNode>();

        dfs(node, newNode);
        return newNode;
    }
    
    
    public void dfs(UndirectedGraphNode ori, UndirectedGraphNode copy) {
        
        map.put(ori.label, copy);
        
        for (UndirectedGraphNode nei: ori.neighbors) {
            int key = nei.label;
            if (!map.containsKey(key)) {
                dfs(nei, new UndirectedGraphNode(key));
            }
            copy.neighbors.add(map.get(key));
        }
        
    }
    
    
    // BFS
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        
        if (node == null) return null;
        
        Queue<UndirectedGraphNode> que = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        que.offer(node);

        
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        map.put(node.label, newNode);
        
        while (!que.isEmpty()) {
            UndirectedGraphNode cur = que.poll();
            UndirectedGraphNode copy = map.get(cur.label);

            for (UndirectedGraphNode n: cur.neighbors) {
                if (!map.containsKey(n.label)) {
                    map.put(n.label, new UndirectedGraphNode(n.label));
                    que.offer(n);
                }
                copy.neighbors.add(map.get(n.label));
                
            }
        }
        
        return newNode;
    }

}
