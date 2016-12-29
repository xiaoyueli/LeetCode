package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * Given a collection of intervals, merge all overlapping intervals.

    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
 *
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


public class _56_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i, Interval j) {
                return i.start - j.start;
            }
        });
        
        List<Interval> res = new ArrayList<Interval>();
        
        if (intervals == null || intervals.size() == 0) return res;
        
        Interval cur = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (cur.end < next.start) {
                res.add(cur);
                cur = next;
            }
            else if (cur.end < next.end) cur.end = next.end;
        }
        
        res.add(cur);
        
        return res;
    }
}
