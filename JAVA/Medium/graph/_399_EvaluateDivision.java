package graph;

/**
 * Equations are given in the format A / B = k, 
 * where A and B are variables represented as strings, and k is a real number (floating point number). 
 * Given some queries, return the answers. If the answer does not exist, return -1.0.
 * 
 * Example:
 * Given a / b = 2.0, b / c = 3.0. 
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , 
 * where equations.size() == values.size(), and the values are positive. 
 * This represents the equations. Return vector<double>.
 * 
 * According to the example above:
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 * 
 * The input is always valid. 
 * You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 * 
 * 思路：
 * 建立有向图，BFS
 * 
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _399_EvaluateDivision {
	
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        MyGraph graph = new MyGraph();
        
        initializeData(graph, equations, values);
        
        int len = queries.length;
        double[] res = new double[len];
        
        for (int idx = 0; idx < len; idx++) {
            String[] query = queries[idx];
            res[idx] = graph.getDistance(query[0], query[1]);
        }
        
        return res;
                 
    }
    
    private void initializeData(MyGraph gra, String[][] equs, double[] values) {
        
        int len = equs.length;
        for (int idx = 0; idx < len; idx++) {
            String from = equs[idx][0];
            String to = equs[idx][1];
            double distance = values[idx];
            gra.addEdge(from, to, distance);
            gra.addEdge(to, from, 1.0 / distance);
        }
    }

}

class MyGraph {
    
    HashMap<String, HashMap<String, Double>> graph;
    
    public MyGraph() {
        graph = new HashMap<String, HashMap<String, Double>>();
    }
    
    public void addEdge(String from, String to, double distance) {
        if (!graph.containsKey(from)) graph.put(from, new HashMap<String, Double>());
        graph.get(from).put(to, distance);
    }
    
    public double getDistance(String from, String to) {
        if (!graph.containsKey(from)) return -1.0;
        
        Queue<String> que = new LinkedList<String>();
        que.offer(from);
        HashMap<String, Double> visited = new HashMap<String, Double>();
        visited.put(from, 1.0);
        
        while (!que.isEmpty()) {
            String cur = que.poll();
            double val = visited.get(cur);
            HashMap<String, Double> destinations = graph.get(cur);
            
            for (String key: destinations.keySet()) {
                double dis = destinations.get(key);
                double newDis = val * dis;
                if (key.equals(to)) return newDis;
                if (!visited.containsKey(key)) {
                    visited.put(key, newDis);
                    que.offer(key);
                }
            }
        }
        
        return -1.0;
    }
    
}
