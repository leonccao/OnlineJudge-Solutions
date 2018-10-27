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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        List<Interval> ans = new ArrayList<Interval>();
        Interval cur = null;
        for (Interval interval : intervals) {
            if (cur == null) {
                cur = interval;
                continue;
            }
            if (interval.start > cur.end) {
                ans.add(cur);
                cur = interval;
            } else {
                cur.end = Math.max(cur.end, interval.end);
            }         
        }
        if (cur != null) ans.add(cur);
        return ans;
    }
}

// new
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<Interval>();
        if (intervals.size() == 0) return ans;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval cur = null;
        for (Interval interval : intervals) {
            if (cur == null) {cur = interval; continue;}
            if (cur.end < interval.start) {
                ans.add(cur);
                cur = interval;
            } else cur.end = Math.max(cur.end, interval.end);
        }
        ans.add(cur);
        return ans;
    }
}