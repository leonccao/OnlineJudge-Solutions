import java.util.*;

public class Main {
    
    public static class Flight {
        int a, b, s, e, index;
        public Flight(int index, int a, int b, int s, int e) {
            this.index = index;
            this.a = a;
            this.b = b;
            this.s = s;
            this.e = e;
        }
    }

    public static class Node {
        long x, y;
        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Flight[] flights = new Flight[m];
        for (int i = 0; i < m; i ++)
            flights[i] = new Flight(i,
                    sc.nextInt() - 1,
                    sc.nextInt() - 1,
                    sc.nextInt(),
                    sc.nextInt());
        sc.close();

        Flight[] start = Arrays.copyOf(flights, m);
        Flight[] end   = Arrays.copyOf(flights, m);
        Arrays.sort(start, (a, b) -> a.s - b.s);
        Arrays.sort(end,   (a, b) -> a.e - b.e);

        int count = 0;
        long[] f = new long[m];
        List<List<Node>> airport = new ArrayList<>();
        for (int i = 0; i < m; i ++)
            airport.add(new ArrayList<>());
        airport.get(0).add(new Node(0, 0));
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < m; i ++) {
            Flight cur = start[i];
            while (count < m && end[count].e < cur.s) {
                if (f[end[count].index] < 0) {count ++; continue;}
                insert(end[count], airport.get(end[count].b), f[end[count].index]);
                count ++;
            }
            f[cur.index] = find(airport.get(cur.a), cur.s);
            if (cur.b == n - 1 && f[cur.index] > -1)
                ans = Math.min(ans, f[cur.index]);
        }
        System.out.println(ans);
    }

    private static long find(List<Node> list, int s) {
        if (list.size() == 0) return -1;
        int l = 0, r = list.size();
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            Node cur = list.get(mid);
            Node pre = list.get(mid - 1);
            double g = (double)(cur.y - pre.y) / (cur.x - pre.x);
            if (g < 2 * s) l = mid;
            else r = mid;
        }
        Node cur = list.get(l);
        return cur.y + cur.x * (-2 * s) + (long)s * s;
    }

    private static void insert(Flight flight, List<Node> list, long f) {
        Node cur = new Node(flight.e, f + (long)flight.e * flight.e);
        while (list.size() > 1) {
            Node pre = list.get(list.size() - 1);
            Node ppre = list.get(list.size() - 2);
            double gb = (double)(cur.y - pre.y) / (cur.x - pre.x);
            double ga = (double)(pre.y - ppre.y) / (pre.x - ppre.x);
            if (ga <= gb) break;
            list.remove(list.size() - 1);
        }
        list.add(cur);
    }
}
