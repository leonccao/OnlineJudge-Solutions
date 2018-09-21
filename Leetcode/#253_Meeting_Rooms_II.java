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
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (Interval interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval.start)
                pq.poll();
            pq.add(interval.end);
        }
        return pq.size();
    }
}

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
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends   = new int[intervals.length];
        for (int i = 0; i < intervals.length; i ++) {
            starts[i] = intervals[i].start;
            ends[i]   = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int j = 0, ans = 0;
        for (int i = 0; i < intervals.length; i ++) {
            if (starts[i] < ends[j]) ans ++;
            else j ++;
        }
        return ans;
    }
}