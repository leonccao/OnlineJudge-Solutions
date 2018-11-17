import java.util.*;

public class Main {

    static int[][] edge;

    private static int[] dijkstra(int start) {
        int[] dist = new int[edge.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]);
        pq.add(new int[] {start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll()[0];
            for (int i = 0; i < edge.length; i ++) {
                if (edge[cur][i] == 0) continue;
                if (dist[cur] + edge[cur][i] < dist[i]) {
                    dist[i] = dist[cur] + edge[cur][i];
                    pq.add(new int[] {i, dist[i]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        edge = new int[n][n];
        for (int i = 0; i < m; i ++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            edge[a][b] = edge[b][a] = c;
        }
        int[][] gigs = new int[g][4];
        for (int i = 0; i < g; i ++) {
            gigs[i][0] = sc.nextInt() - 1;
            gigs[i][1] = sc.nextInt();
            gigs[i][2] = sc.nextInt();
            gigs[i][3] = sc.nextInt();
        }

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i ++)
            dist[i] = dijkstra(i);
        Arrays.sort(gigs, (a, b) -> a[2] - b[2]);
        List<TreeMap<Integer, Long>> f = new ArrayList<>();
        for (int i = 0; i < n; i ++)
            f.add(new TreeMap<>());
        f.get(0).put(0, (long)0);

        long ans = 0;
        for (int[] gig : gigs) {
            long sum = Long.MIN_VALUE;
            for (int i = 0; i < n; i ++) {
                int limit = gig[1] - dist[i][gig[0]];
                Map.Entry<Integer, Long> tmp = f.get(i).floorEntry(limit);
                if (tmp == null) continue;
                sum = Math.max(sum, tmp.getValue() + gig[3]);
            }
            if (sum <= 0) continue;
            ans = Math.max(ans, sum);
            TreeMap<Integer, Long> map = f.get(gig[0]);
            if (map.isEmpty() || sum > map.lastEntry().getValue())
                map.put(gig[2], sum);
        }
        System.out.println(ans);
    }
}
