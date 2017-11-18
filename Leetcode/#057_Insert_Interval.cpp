/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        vector<Interval> result;
        if (intervals.empty()) {
            result.push_back(newInterval);
            return result;
        }
        
        intervals.push_back(newInterval);
        sort(intervals.begin(), intervals.end(), cmp);
        Interval in = intervals[0];
        for (int i = 1; i < intervals.size(); i ++) {
            if (intervals[i].start <= in.end) {
                if (intervals[i].end <= in.end) continue;
                in.end = intervals[i].end;
            } else {
                result.push_back(in);
                in = intervals[i];
            }
        }
        result.push_back(in);
        return result;
    }
    static bool cmp(const Interval &a, const Interval &b) {
        if (a.start != b.start)
            return a.start < b.start;
        else return a.end < b.end;
    }
};