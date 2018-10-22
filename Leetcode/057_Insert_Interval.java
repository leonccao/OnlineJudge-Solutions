/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<Interval>();
        boolean inserted = false;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start)
                ans.add(interval);
            else if (interval.start > newInterval.end) {
                if (!inserted) {
                    ans.add(newInterval);
                    inserted = true;
                }
                ans.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        if (!inserted) ans.add(newInterval);
        return ans;
    }
}