/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {

    int range;
    List<Integer> father;
    
    private int find(int x) {
        //System.out.println(x + " " + father.get(x));
        if (father.get(x) == x) return x;
        father.set(x, find(father.get(x)));
        return father.get(x);
    }
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        father = new ArrayList<Integer>();
        father.add(0);
        range = 0;
    }
    
    public void addNum(int val) {
        if (val >= range) {
            for (int i = range + 1; i <= val + 1; i ++) {
                father.add(i);
                //System.out.println("i: " + i + " " + father.get(i));
            }
            range = val + 1;
        }
        father.set(val, val + 1);
        //System.out.println("val: " + val + " " + father.get(val));
    }
    
    public List<Interval> getIntervals() {
        List<Interval> ans = new LinkedList<Interval>();
        
        int pos = 0;
        while (pos < range) {
            int fa = find(pos);
            if (fa != pos) {
                ans.add(new Interval(pos, fa - 1));
                pos = fa;
            }
            pos ++;
        }
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */