package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, 
 * for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, 
 * is it possible for you to finish all courses?
 * 
 * For example:
 * 2, [[1,0]]
 * 
 * There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, 
 * and to take course 0 you should also have finished course 1. 
 * So it is impossible.
 * 
 * Note:
 * The input prerequisites is a graph represented by a list of edges, 
 * not adjacency matrices. Read more about how a graph is represented.
 *
 * # 将入度为0的结点进行BFS，更新被入度结点入度 数
 * 
 * dfs TLE?
 */

public class _207_CourseSchedule {
    
    // 二维数组建图
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        boolean[][] graph = new boolean[numCourses][numCourses]; 

        int[] degree = new int[numCourses];
        int edgeNum = prerequisites.length;
        for (int idx = 0; idx < edgeNum; idx++) {
            int[] edge = prerequisites[idx];
            int cur = edge[0];
            int pre = edge[1];
            if (graph[cur][pre]) continue;
            graph[cur][pre] = true;
            degree[pre]++; 
        }
        
        Queue<Integer> que = new LinkedList<Integer>();
        
        int cnt = 0;
        for (int idx = 0; idx < numCourses; idx++) {
            if (degree[idx] == 0) {
                que.offer(idx);
                cnt++;
            }
        }
        while (!que.isEmpty()) {
            int cur = que.poll();
            
            for (int idx = 0; idx < numCourses; idx++) {
                if (graph[cur][idx] == true) {
                    degree[idx]--;
                    if (degree[idx] == 0) {
                        cnt++;
                        que.offer(idx);
                    }
                }
            }
        }
        
        return cnt == numCourses;
        
    }
    
    
    // List建图
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        
        List<HashSet<Integer>> graph = new ArrayList<>(); 
        
        for (int idx = 0; idx < numCourses; idx++) graph.add(new HashSet<Integer>());

        int[] degree = new int[numCourses];
        int edgeNum = prerequisites.length;
        for (int idx = 0; idx < edgeNum; idx++) {
            int[] edge = prerequisites[idx];
            int cur = edge[0];
            int pre = edge[1];
            HashSet<Integer> set = graph.get(cur);
            if (set.contains(pre)) continue;
            set.add(pre);
            degree[pre]++; 
        }
        
        Queue<Integer> que = new LinkedList<Integer>();
        
        int cnt = 0;
        for (int idx = 0; idx < numCourses; idx++) {
            if (degree[idx] == 0) {
                que.offer(idx);
                cnt++;
            }
        }
        while (!que.isEmpty()) {
            int cur = que.poll();
            
            HashSet<Integer> nexts = graph.get(cur);
            if (nexts == null) continue;
            for (int i: nexts) {
                degree[i]--;
                if (degree[i] == 0) {
                    cnt++;
                    que.offer(i);
                }
            }
            
        }
        
        return cnt == numCourses;
        
    }
    
    public static void main(String[] args) {
        _207_CourseSchedule test = new _207_CourseSchedule();
        test.canFinish(10, new int[][] {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}});
    }

}
