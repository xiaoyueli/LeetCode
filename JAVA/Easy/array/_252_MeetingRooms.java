package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings.

    For example,
    Given [[0, 30],[5, 10],[15, 20]],
    return false.
 *
 * 思路，按start排序，然后比较前一个数的end和后一个数的start
 * 
 * 也可以用PriorityQueue
 */

/**
 * Definition for an interval.
 */
class Interval {
 int start;
 int end;
 Interval() { start = 0; end = 0; }
 Interval(int s, int e) { start = s; end = e; }
}

 

public class _252_MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        
        if (intervals == null || intervals.length == 0) return true;
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            
           public int compare(Interval i1, Interval i2) {
               return i1.start - i2.start;
           } 
        });
        
          
        for (int idx = 0; idx + 1 < intervals.length; idx++) {
            if (intervals[idx].end > intervals[idx + 1].start) return false;
        }
        
        return true;
    }
}
