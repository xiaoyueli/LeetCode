package facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author xiaoyue
 * list of sorted integer arrays，要求找所有的数的median. e.g. [1,3,6,7,9], [2,4, 8], [5], return 5
 */


public class MedianOfLists {
    
    
    public double solve(List<int[]> lists) {
        
        int[][] map = new int[lists.size()][];
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 0; i < lists.size(); i++) {
            map[i] = new int[]{0, lists.get(i).length};
            que.offer(i);
        }
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int size = que.size();
        while (!que.isEmpty()) {
            int idx = que.poll();
            size--;
            int median = getMedian(lists, map, idx);
            if (median < min) {
                min = median;
                minIdx = idx;
            }
            else if (median > max) {
                max = median;
                maxIdx = idx;
            }
            else que.offer(idx);
            
            if (size == 0) {
                int minlen = (map[minIdx][1] - map[minIdx][0] - 1) / 2;
                int maxlen = (map[maxIdx][1] - map[maxIdx][0]) / 2;
                int len = Math.min(minlen, maxlen);
                map[minIdx][0] += len;
                if (map[minIdx][0] <= map[minIdx][1]) que.offer(minIdx);
                map[maxIdx][1] -= len;
                if (map[maxIdx][0] <= map[maxIdx][1]) que.offer(maxIdx);
                size = que.size();
                if (size <= 2) break;
            }
        }
        
        int idx1 = que.poll();
        int idx2 = que.poll();
        return helper(lists.get(idx1), map[idx1], lists.get(idx2), map[idx2]);
        
  
    }
    
    private double helper(Queue<List<Integer>> que, int k) {
        
        int size = que.size();
        List<Integer> ls = que.poll();
        while (k != 0 && !que.isEmpty()) {
            List<Integer> cur = que.poll();
        }
    }

}
