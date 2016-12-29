package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author xiaoyue
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.

    For example,
    Given [[0, 30],[5, 10],[15, 20]],
    return 2.
 * 
 * 思路：
 * 按开始时间排序，
 * 然后用priorityQueue根据end的时间记录最早结束的事件，
 * 遍历数组，新加入的元素开始时间大于当前最早结束事件END值就更新最早结束END值，否者将该事件加入QUE，再将当前最早结束事件加入QUE，
 * 最后QUE的SIZE就是需要的房间数
 */

class Interval {
 int start;
 int end;
 Interval() { start = 0; end = 0; }
 Interval(int s, int e) { start = s; end = e; }
}

public class _253_MeetingRooms2 {
    
    public int minMeetingRooms(Interval[] intervals) {
        
        if (intervals == null || intervals.length == 0) return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        PriorityQueue<Interval> que = new PriorityQueue<Interval>(new Comparator<Interval>(){
            
           @Override
        public int compare(Interval i1, Interval i2) {
               return i1.end - i2.end;
           } 
        });
        
        que.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval earlistEnd = que.poll();
            if (intervals[i].start >= earlistEnd.end) {
                earlistEnd.end = intervals[i].end;
            }
            else que.offer(intervals[i]);
            que.offer(earlistEnd);
        }
        
        return que.size();
        
    }

}
