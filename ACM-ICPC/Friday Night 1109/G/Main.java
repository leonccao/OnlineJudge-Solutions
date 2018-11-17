import java.util.*;

public class Main {

    private static class Edge {
        int from, dest, cut;
        Edge oppo;
        public Edge(int from, int dest) {
            this.from = from;
            this.dest = dest;
            cut = 0;
        }
    }

    static int[] low, dfn, dist;
    static List<List<Edge>> graph;
    static int timeStamp = 0;

    private static void addEdge(int a, int b) {
        Edge edge = new Edge(a, b);
        Edge oppo = new Edge(b, a);
        edge.oppo = oppo;
        oppo.oppo = edge;
        graph.get(a).add(edge);
        graph.get(b).add(oppo);
    }

    private static void tarjan(int cur, Edge prev) {
        dfn[cur] = low[cur] = timeStamp ++;
        for (Edge edge : graph.get(cur)) {
            if (dfn[edge.dest] == -1) {
                tarjan(edge.dest, edge);
                low[cur] = Math.min(low[cur], low[edge.dest]);
            } else if (prev == null || edge.dest != prev.from)
                low[cur] = Math.min(low[cur], dfn[edge.dest]);
        }
        if (prev != null && low[cur] == dfn[cur]) {
            prev.cut = 1;
            prev.oppo.cut = 1;
        }
    }

    private static int find(int start) {
        Arrays.fill(dist, -1);
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(start);
        dist[start] = 0;
        int cur = -1;
        while (!deque.isEmpty()) {
            cur = deque.pollFirst();
            for (Edge edge : graph.get(cur)) {
                if (dist[edge.dest] != -1) continue;
                dist[edge.dest] = dist[cur] + edge.cut;
                if (edge.cut > 0)
                    deque.addLast(edge.dest);
                else deque.addFirst(edge.dest);
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i ++) 
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i ++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            addEdge(a, b);
        }

        // tarjan
        low = new int[n];
        dfn = new int[n];
        Arrays.fill(low, -1);
        Arrays.fill(dfn, -1);
        for (int i = 0; i < n; i ++)
            if (dfn[i] == -1)
                tarjan(i, null);

        dist = new int[n];
        int ans = find(find(0));
        System.out.println(dist[ans]);
    }
}
