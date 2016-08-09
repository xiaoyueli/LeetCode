package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
 * reconstruct the itinerary in order. 
 * All of the tickets belong to a man who departs from JFK. 
 * Thus, the itinerary must begin with JFK.
 * 
 * Note:
 * If there are multiple valid itineraries, 
 * you should return the itinerary that has the smallest lexical order when read as a single string. 
 * 
 * For example, 
 * the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * 
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * 
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. 
 * But it is larger in lexical order.
 * 
 * # 
 * 旅游规划，机票排序dfs + heap
 * hashmap 建图，pq保存到达城市
 * 方法一： dfs 从出发地遍历，当没有后续到达城市时将其压入List（原理同栈），否则继续dfs
 * 方法二：dfs 从出发地遍历，到达城市相当于对应一张机票
 * dfs排序值最小的城市，机票使用数+1
 * 
 *
 */

public class _332_ReconstructItinerary {
    
    HashMap<String, PriorityQueue<String>> gra;
    List<String> res;
    boolean isFind;
    
    public List<String> findItinerary(String[][] tickets) {
        isFind = false;
        gra = new HashMap<String, PriorityQueue<String>>();
        for (String[] t: tickets) {
            String from = t[0];
            if (!gra.containsKey(from)) gra.put(from, new PriorityQueue<String>());
            gra.get(from).offer(t[1]);
        }
        
        res = new LinkedList<String>();
        dfs("JFK");
        
        return res;
    }
    
    public void dfs(String city) {

        PriorityQueue<String> toCities = gra.get(city);
        
        if (toCities != null && !toCities.isEmpty()) {
            while (!toCities.isEmpty()) {
                String to = toCities.poll();
                dfs(to);
            }
        }

        res.add(0, city);
        
    }
    

//    HashMap<String, PriorityQueue<String>> gra;
//    List<String> res;
//    boolean isFind;
//    public List<String> findItinerary(String[][] tickets) {
//        isFind = false;
//        gra = new HashMap<String, PriorityQueue<String>>();
//        for (String[] t: tickets) {
//            String from = t[0];
//            if (!gra.containsKey(from)) gra.put(from, new PriorityQueue<String>());
//            gra.get(from).offer(t[1]);
//        }
//        
//        res = new ArrayList<String>();
//        
//        dfs("JFK", 0, tickets.length);
//        
//        return res;
//   
//    }
//    
//    public void dfs(String city, int cnt, int total) {
//        res.add(city);
//
//        PriorityQueue<String> toCities = gra.get(city);
//        
//        if (cnt == total) {
//            isFind = true;
//            return;
//        }
//        
//        if (toCities == null || toCities.isEmpty()) return;
//
//        PriorityQueue<String> cities = new PriorityQueue<String>(toCities);
//        while (!cities.isEmpty()) {
//            String c = cities.poll();
//            toCities.remove(c);
//            dfs(c, cnt + 1, total);
//            if (isFind) return;
//            int len = res.size();
//            res.remove(len - 1);           
//            toCities.offer(c);
//        }
//        
//    }
    
    
    public static void main(String[] args) {
        _332_ReconstructItinerary  test = new _332_ReconstructItinerary ();
        test.findItinerary(new String[][]{{"AXA","EZE"},{"EZE","AUA"},{"ADL","JFK"},{"ADL","TIA"},{"AUA","AXA"},{"EZE","TIA"},{"EZE","TIA"},{"AXA","EZE"},{"EZE","ADL"},{"ANU","EZE"},{"TIA","EZE"},{"JFK","ADL"},{"AUA","JFK"},{"JFK","EZE"},{"EZE","ANU"},{"ADL","AUA"},{"ANU","AXA"},{"AXA","ADL"},{"AUA","JFK"},{"EZE","ADL"},{"ANU","TIA"},{"AUA","JFK"},{"TIA","JFK"},{"EZE","AUA"},{"AXA","EZE"},{"AUA","ANU"},{"ADL","AXA"},{"EZE","ADL"},{"AUA","ANU"},{"AXA","EZE"},{"TIA","AUA"},{"AXA","EZE"},{"AUA","SYD"},{"ADL","JFK"},{"EZE","AUA"},{"ADL","ANU"},{"AUA","TIA"},{"ADL","EZE"},{"TIA","JFK"},{"AXA","ANU"},{"JFK","AXA"},{"JFK","ADL"},{"ADL","EZE"},{"AXA","TIA"},{"JFK","AUA"},{"ADL","EZE"},{"JFK","ADL"},{"ADL","AXA"},{"TIA","AUA"},{"AXA","JFK"},{"ADL","AUA"},{"TIA","JFK"},{"JFK","ADL"},{"JFK","ADL"},{"ANU","AXA"},{"TIA","AXA"},{"EZE","JFK"},{"EZE","AXA"},{"ADL","TIA"},{"JFK","AUA"},{"TIA","EZE"},{"EZE","ADL"},{"JFK","ANU"},{"TIA","AUA"},{"EZE","ADL"},{"ADL","JFK"},{"ANU","AXA"},{"AUA","AXA"},{"ANU","EZE"},{"ADL","AXA"},{"ANU","AXA"},{"TIA","ADL"},{"JFK","ADL"},{"JFK","TIA"},{"AUA","ADL"},{"AUA","TIA"},{"TIA","JFK"},{"EZE","JFK"},{"AUA","ADL"},{"ADL","AUA"},{"EZE","ANU"},{"ADL","ANU"},{"AUA","AXA"},{"AXA","TIA"},{"AXA","TIA"},{"ADL","AXA"},{"EZE","AXA"},{"AXA","JFK"},{"JFK","AUA"},{"ANU","ADL"},{"AXA","TIA"},{"ANU","AUA"},{"JFK","EZE"},{"AXA","ADL"},{"TIA","EZE"},{"JFK","AXA"},{"AXA","ADL"},{"EZE","AUA"},{"AXA","ANU"},{"ADL","EZE"},{"AUA","EZE"}});
//        test.findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}});
//        test.findItinerary(new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}});
    }

}
