import java.util.*;

public class Main {
    private static class Edge {
        int prev, dest, cap, cost;
        Edge oppo, back;
        public Edge(int prev, int dest, int cap, int cost) {
            this.prev = prev;
            this.dest = dest;
            this.cap = cap;
            this.cost = cost;
        }
    }

    static List<List<Edge>> graph;
    static int[] dist;
    static Edge[] prev;

    private static void addEdge(int a, int b, int cap, int cost) {
        Edge eOrig  = new Edge(a, b, cap,  cost);
        Edge eOppo  = new Edge(b, a,   0, -cost);
        Edge eBack  = new Edge(b, a, cap,  cost);
        Edge eBkOp  = new Edge(a, b,   0, -cost);
        eOrig.oppo = eOppo; eOrig.back = eBack;
        eOppo.oppo = eOrig; eOppo.back = null;
        eBack.oppo = eBkOp; eBack.back = eOrig;
        eBkOp.oppo = eBack; eBkOp.back = null;
        graph.get(a).add(eOrig);
        graph.get(b).add(eOppo);
        graph.get(b).add(eBack);
        graph.get(a).add(eBkOp);
    }

    private static int spfa(int start, int end) {
        int[] flow = new int[dist.length];
        Set<Integer> visited = new HashSet<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;
        flow[start] = Integer.MAX_VALUE;
        flow[end] = 0;
        visited.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited.remove(cur);
            for (Edge edge : graph.get(cur)) {
                int dest = edge.dest;
                if (edge.cap > 0 && dist[cur] + edge.cost < dist[dest]) {
                    dist[dest] = dist[cur] + edge.cost;
                    prev[dest] = edge;
                    flow[dest] = Math.min(flow[cur], edge.cap);
                    if (!visited.contains(dest)) {
                        queue.add(dest);
                        visited.add(dest);
                    }
                }
            }
        }
        return flow[end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input
        int p = sc.nextInt();
        int r = sc.nextInt() + 2;
        int l = sc.nextInt();
        // init graph
        graph = new ArrayList<>();
        for (int i = 0; i < r; i ++)
            graph.add(new ArrayList<>());
        // add edges
        for (int i = 0; i < l; i ++) {
            int a = sc.nextInt() + 2;
            int b = sc.nextInt() + 2;
            addEdge(a, b, 1, 1);
        }

        // MCMF
        int start = 0, end = 1, maxFlow = 0, minCost = 0, flow;
        dist = new int[r];
        prev = new Edge[r];
        while ((flow = spfa(start, end)) > 0) {
            int last = end;
            maxFlow += flow;
            minCost += flow * dist[end];
            if (maxFlow == p) break;
            while (last != start) {
                Edge edge = prev[last];
                edge.cap -= flow;
                if (edge.back != null) 
                    edge.back.cap -= flow;
                edge.oppo.cap += flow;
                if (edge.oppo.back != null)
                    edge.oppo.back.cap += flow;
                last = edge.prev;
            }
        }

        // output
        if (maxFlow == p) System.out.println(minCost);
        else System.out.println((p - maxFlow) + " people left behind");
    }
}
