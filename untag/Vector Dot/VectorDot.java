import java.util.*;

public class VectorDot {

    public int[] dotHash(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i ++)
            if (a[i] > 0)
                map.put(i, a[i]);
        int[] c = new int[a.length];
        for (int i = 0; i < b.length; i ++)
            if (b[i] > 0 && map.containsKey(i))
                c[i] = b[i] * map.get(i);
        return c;
    }

    private class Vector {
        int index, value;
        public Vector(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    private int binarySearch(List<Vector> a, int target) {
        int l = 0, r = a.size();
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (a.get(mid).index == target)
                return a.get(mid).value;
            else if (a.get(mid).index < target)
                l = mid + 1;
            else r = mid;
        }
        if (l >= a.size() || a.get(l).index != target) return 0;
        return a.get(l).value;
    }

    public int[] dotList(int[] va, int[] vb) {
        List<Vector> a = new ArrayList<>();
        for (int i = 0; i < va.length; i ++)
            if (va[i] > 0)
                a.add(new Vector(i, va[i]));
        List<Vector> b = new ArrayList<>();
        for (int i = 0; i < vb.length; i ++)
            if (vb[i] > 0)
                b.add(new Vector(i, vb[i]));
        int[] c = new int[va.length];
        /*
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            while (i < a.size() && a.get(i).index < b.get(j).index) i ++;
            if (i == a.size()) break;
            while (j < b.size() && a.get(i).index > b.get(j).index) j ++;
            if (j == b.size()) break;
            c[a.get(i).index] = a.get(i ++).value * b.get(j ++).value;
        }
        */

        for (int i = 0; i < b.size(); i ++) {
            int tmp = binarySearch(a, b.get(i).index);
            if (tmp != 0) {
                tmp *= b.get(i).value;
                c[b.get(i).index] = tmp;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        VectorDot sol = new VectorDot();

        int len = 1000;
        int[] a = new int[len];
        a[200] = 200;
        a[300] = 300;
        a[500] = 500;
        int[] b = new int[len];
        b[100] = 100;
        b[200] = 203;
        b[500] = 504;

        int[] c = sol.dotList(a, b);
        for (int i = 0; i < c.length; i ++)
            if (c[i] > 0)
                System.out.println(i + " " + c[i]);
    }
}