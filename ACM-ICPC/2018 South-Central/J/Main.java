import java.util.*;

public class Main {

    private static class Edge {
        int dest, cap;
        Edge oppo;
        public Edge(int dest, int cap) {
            this.dest = dest;
            this.cap  = cap;
        }
    }

    static List<List<Edge>> graph;
    static int[] depth;

    private static void addEdge(int a, int b, int cap) {
        Edge edge = new Edge(b, cap);
        Edge oppo = new Edge(a, 0);
        edge.oppo = oppo;
        oppo.oppo = edge;
        graph.get(a).add(edge);
        graph.get(b).add(oppo);
    }

    private static boolean bfs(int start, int end) {
        Arrays.fill(depth, -1);
        depth[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Edge edge : graph.get(cur)) {
                int dest = edge.dest;
                if (edge.cap > 0 && depth[dest] < 0)  {
                    depth[dest] = depth[cur] + 1;
                    queue.add(dest);
                }
            }
        }
        return depth[end] > 0;
    }

    private static int dinic(int cur, int end, int limit) {
        if (cur == end || limit == 0) return limit;
        int flow = 0, tmp;
        for (Edge edge : graph.get(cur)) {
            if (depth[edge.dest] != depth[cur] + 1) continue;
            if ((tmp = dinic(edge.dest, end, Math.min(edge.cap, limit))) > 0) {
                edge.cap -= tmp;
                edge.oppo.cap += tmp;
                flow += tmp;
                limit -= tmp;
                if (limit == 0) break;
            }
        }
        return flow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test ++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            // init graph
            graph = new ArrayList<>();
            for (int i = 0; i < n; i ++)
                graph.add(new ArrayList<>());
            for (int i = 0; i < m; i ++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                int c = sc.nextInt();
                addEdge(a, b, c);
            }

            int start = 0, end = n - 1, ans = 0;
            depth = new int[n];
            while (bfs(start, end))
                ans += dinic(start, end, Integer.MAX_VALUE);
            System.out.println("Case " + test + ": " + ans);
        }
    }
}
