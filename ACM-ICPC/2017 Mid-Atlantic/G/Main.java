import java.util.*;
import java.lang.*;

public class Main {

    final static long MAX = (long)Math.pow(10, 10);

    public static class Interval {
        long start, end;
        String ch = "$";
        public Interval(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Interval> a = new ArrayList<>();
        a.add(new Interval(1, MAX));
        a = operate(a, sc);
        
        List<Interval> b = new ArrayList<>();
        b.add(new Interval(1, MAX));
        b = operate(b, sc);

        if (a.size() != b.size()) {
            System.out.println(1);
            return;
        }
        for (int i = 0; i < a.size(); i ++) {
            Interval ta = a.get(i);
            Interval tb = b.get(i);
            if (ta.ch.equals(tb.ch) && !ta.ch.equals("$")) continue;
            if (ta.start != tb.start || 
                    ta.end != tb.end ||
                    !ta.ch.equals(tb.ch)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static List<Interval> operate(List<Interval> a, Scanner sc) {
        while (true) {
            String op = sc.next();
            if (op.equals("E")) break;
            long index = (long)sc.nextLong();

            if (op.equals("D")) {
                int i;
                for (i = 0; i < a.size(); i ++) {
                    Interval cur = a.get(i);
                    if (index - (cur.end - cur.start + 1) <= 0) break;
                    index -= (cur.end - cur.start + 1);
                }
                Interval cur = a.get(i);
                index = cur.start + index - 1;
                a.remove(i);
                if (index < cur.end)
                    a.add(i, new Interval(index + 1, cur.end));
                if (cur.start < index) 
                    a.add(i, new Interval(cur.start, index - 1));
            } else {
                String ch = sc.next();
                int i;
                for (i = 0; i < a.size(); i ++) {
                    Interval cur = a.get(i);
                    if (index - (cur.end - cur.start + 1) <= 0) break;
                    index -= (cur.end - cur.start + 1);
                }
                Interval cur = a.get(i);
                index = cur.start + index - 1;
                if (cur.start < index) {
                    a.remove(i);
                    if (index <= cur.end)
                        a.add(i, new Interval(index, cur.end));
                }
                a.add(i, new Interval(index, index));
                a.get(i).ch = ch;
                if (cur.start < index) 
                    a.add(i, new Interval(cur.start, index - 1));
            }
        }
        Interval cur = null;
        List<Interval> tmp = new ArrayList<>();
        for (Interval interval : a) {
            if (!interval.ch.equals("$")) {
                if (cur != null) {tmp.add(cur); cur = null;}
                tmp.add(interval);
            } else if (cur == null) {
                cur = interval;
            } else if (interval.start == cur.end + 1) {
                cur.end = interval.end;
            } else {
                tmp.add(cur);
                cur = interval;
            }
        }
        if (cur != null) tmp.add(cur);
        return tmp;
    }
}
