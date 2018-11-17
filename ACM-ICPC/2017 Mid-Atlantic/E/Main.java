import java.util.*;

public class Main {

    public static class Edge {
        int color, node;
        Edge(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public static class QueueNode {
        int node, start;
        QueueNode(int node, int start) {
            this.node = node;
            this.start = start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Set<Edge>> tree = new HashMap<>();
        for (int i = 0; i < n; i ++)
            tree.put(i, new HashSet<>());
        for (int i = 0; i < n - 1; i ++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            tree.get(a).add(new Edge(b, c));
            tree.get(b).add(new Edge(a, c));
        }

        Queue<QueueNode> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            Map<Integer, Integer> map = new HashMap<>();
            Set<Edge> edges = tree.get(i);
            for (Edge edge : edges) 
                map.put(edge.color, map.getOrDefault(edge.color, 0) + 1);

            List<Edge> garbage = new ArrayList<>();
            for (Edge edge : edges) {
                if (map.get(edge.color) == 1) continue;
                queue.add(new QueueNode(edge.node, i));
                visited.put(edge.node, i);
                garbage.add(edge);
            }
            for (Edge edge : garbage)
                edges.remove(edge);
        }
        while (!queue.isEmpty()) {
            QueueNode cur = queue.poll();
            Set<Edge> edges = tree.get(cur.node);
            for (Edge edge : edges) {
                if (edge.node == cur.start) continue;
                if (visited.containsKey(edge.node)) {
                    if (cur.start != visited.get(edge.node)) {
                        System.out.println(0);
                        sc.close();
                        return;
                    }
                    continue;
                }
                visited.put(edge.node, cur.start);
                queue.add(new QueueNode(edge.node, cur.start));
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i ++)
            if (!visited.containsKey(i))
                ans.add(i + 1);
        System.out.println(ans.size());
        for (int node : ans)
            System.out.println(node);

        sc.close();
    }
}