import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeTwoSortedArraysIntervals {

    public static class Interval {
        int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> merge(List<Interval> a, List<Interval> b) {
        int i = 0, j = 0;
        Interval last = null;
        List<Interval> ans = new ArrayList<>();
        while (i < a.size() || j < b.size()) {
            // pick the one with less start
            Interval cur = null;
            if (j == b.size() || (i < a.size() && a.get(i).start < b.get(j).start)) 
                cur = a.get(i ++);
            else cur = b.get(j ++);

            // merge intervals
            if (last == null) {last = cur; continue;}
            if (last.end < cur.start) {
                ans.add(last);
                last = cur;
            } else last.end = Math.max(last.end, cur.end);
        }
        if (last != null) ans.add(last);
        return ans;
    }

    public List<Interval> intersect(List<Interval> a, List<Interval> b) {
        int i = 0, j = 0;
        List<Interval> ans = new ArrayList<>();
        while (i < a.size() && j < b.size()) {

            Interval cura = a.get(i);
            Interval curb = b.get(j);
            if (!(cura.end < curb.start || curb.end < cura.start)) {
                Interval inter = new Interval(Math.max(cura.start, curb.start), 
                    Math.min(cura.end, curb.end));
                ans.add(inter);
            }

            if (cura.end < curb.end) i ++;
            else j ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MergeTwoSortedArraysIntervals sol = new MergeTwoSortedArraysIntervals();

        List<Interval> a = new ArrayList<>();
        a.add(new Interval(1, 5));
        a.add(new Interval(8, 10));
        a.add(new Interval(15, 25));
        List<Interval> b = new ArrayList<>();
        b.add(new Interval(2, 6));
        b.add(new Interval(25, 100));
        List<Interval> ans = sol.intersect(a, b);
        for (Interval interval : ans) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}