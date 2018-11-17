import java.util.*;

public class Main {

    private static class Edge {
        int prev, dest, capacity, cost, opposite;
        public Edge(int prev, int dest, int capacity, int cost, int opposite) {
            this.prev = prev;
            this.dest = dest;
            this.capacity = capacity;
            this.cost = cost;
            this.opposite = opposite;
        }
    }

    private static void addEdge(int a, int b, int capacity, int cost) {
        graph.get(a).add(new Edge(a, b, capacity,  cost, graph.get(b).size()));
        graph.get(b).add(new Edge(b, a,        0, -cost, graph.get(a).size() - 1));
    };

    static List<List<Edge>> graph;
    static int[] dist;
    static Edge[] pre;

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
                if (edge.capacity > 0 && dist[cur] + edge.cost < dist[edge.dest]) {
                    dist[edge.dest] = dist[cur] + edge.cost;
                    pre[edge.dest] = edge;
                    flow[edge.dest] = Math.min(flow[cur], edge.capacity);
                    if (!visited.contains(edge.dest)) {
                        queue.add(edge.dest);
                        visited.add(edge.dest);
                    }
                }
            }
        }
        return flow[end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n + m == 0) break;
            List<int[]> people = new ArrayList<>();
            List<int[]> houses = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                String s = sc.next();
                for (int j = 0; j < m; j ++)
                    if (s.charAt(j) == 'm')
                        people.add(new int[] {i, j});
                    else if (s.charAt(j) == 'H')
                        houses.add(new int[] {i, j});
            }
            int k = people.size();
            int start = 0, end = k * 2 + 1;

            graph = new ArrayList<>();
            for (int i = 0; i <= end; i ++)
                graph.add(new ArrayList<>());
            for (int i = 0; i < k; i ++)
                addEdge(0, i + 1, 1, 0);
            for (int i = 0; i < k; i ++)
                for (int j = 0; j < k; j ++)
                    addEdge(i + 1, j + k + 1, 1, 
                            (int)(Math.abs(people.get(i)[0] - houses.get(j)[0]) + 
                                  Math.abs(people.get(i)[1] - houses.get(j)[1])));
            for (int i = 0; i < k; i ++)
                addEdge(i + k + 1, end, 1, 0);

            // MCMF
            dist = new int[end + 1];
            pre = new Edge[end + 1];
            int maxFlow = 0, minCost = 0, flow;
            while ((flow = spfa(start, end)) > 0) {
                int last = end;
                maxFlow += flow;
                minCost += flow * dist[end];
                while (last != start) {
                    Edge edge = pre[last];
                    edge.capacity -= flow;
                    graph.get(edge.dest).get(edge.opposite).capacity += flow;
                    last = edge.prev;
                }
            }
            System.out.println(minCost);
        }
    }
}
