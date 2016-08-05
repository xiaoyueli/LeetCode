package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, 
 * labeled from 0 to n - 1.
 * Some courses may have prerequisites, 
 * for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, 
 * return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, 
 * you just need to return one of them. 
 * If it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 2, [[1,0]]
 * 
 * There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. 
 * So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * 
 * There are a total of 4 courses to take. 
 * To take course 3 you should have finished both courses 1 and 2.
 * Both courses 1 and 2 should be taken after you finished course 0. 
 * So one correct course order is [0,1,2,3]. 
 * Another correct ordering is[0,2,1,3].
 * 
 * Note:
 * The input prerequisites is a graph represented by a list of edges, 
 * not adjacency matrices. 
 * Read more about how a graph is represented.
 * 
 * # 拓扑排序
 *
 */

public class _210_CourseSchedule2 {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<HashSet<Integer>> gra = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) gra.add(new HashSet<Integer>());
        
        int[] degree = new int[numCourses];
        for (int[] pre: prerequisites) {
            HashSet<Integer> set = gra.get(pre[0]);
            int ver = pre[1];
            if (set.contains(ver)) continue;
            degree[ver]++;
            set.add(ver);
        }
        
        int[] res = new int[numCourses];
        int cnt = numCourses - 1;
        Queue<Integer> que = new LinkedList<Integer>();
        
        for (int idx = 0; idx < numCourses; idx++) {
            if (degree[idx] == 0) {
                que.offer(idx);
                res[cnt--] = idx;
            }
        }
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            HashSet<Integer> set = gra.get(cur);
            if (set.isEmpty()) continue;
            for (int v: set) {
                degree[v]--;
                if (degree[v] == 0) {
                    res[cnt--] = v;
                    que.offer(v);
                }
            }
        }
        if (cnt == -1) return res;
        else return new int[0];
        
    }

}
