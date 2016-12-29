package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    
    You may assume that the intervals were initially sorted according to their start times.
    
    Example 1:
    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
    
    Example 2:
    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
    
    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class _57_InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> res = new ArrayList<Interval>();
        
        for (Interval cur: intervals) {
            if (newInterval.start > cur.end) res.add(cur);
            else if (newInterval.end < cur.start) {
                res.add(newInterval);
                newInterval = cur;
            }
            else{
                if (cur.start < newInterval.start) newInterval.start = cur.start;
                if (cur.end > newInterval.end) newInterval.end = cur.end;
            } 
        }
        
        res.add(newInterval);
        
        return res;
    }
}
