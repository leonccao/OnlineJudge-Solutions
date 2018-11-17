// Be careful wether the edge is directed or not;

import java.util.*;

public class Main {

    public static class Line {
        int city, cost, color;
        public Line(int city, int cost, int color) {
            this.city = city;
            this.cost = cost;
            this.color = color;
        }
    }

    public static class QueueNode {
        int city, red, blue;
        String str;
        public QueueNode(int city, int red, int blue) {
            this.city = city;
            this.red = red;
            this.blue = blue;
            str = "" + city + " " + red + " " + blue;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int redLim = sc.nextInt();
        int blueLim = sc.nextInt();
        Map<Integer, List<Line>> graph = new HashMap<>();
        for (int i = 1; i <= n; i ++)
            graph.put(i, new ArrayList<>());
        for (int i = 0; i < m; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            int color = sc.nextInt();
            graph.get(a).add(new Line(b, cost, color));
            graph.get(b).add(new Line(a, cost, color));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        sc.close();

        Queue<QueueNode> queue = new LinkedList<>();
        Map<String, Long> dist = new HashMap<>();
        Set<String> visited = new HashSet<>();
        QueueNode cur = new QueueNode(start, 0, 0);
        queue.add(cur);
        dist.put(cur.str, (long)0);
        visited.add(cur.str);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            visited.remove(cur.str);
            List<Line> lines = graph.get(cur.city);
            for (Line line : lines) {
                QueueNode next = new QueueNode(line.city,
                        cur.red  + (line.color == 1 ? 1 : 0),
                        cur.blue + (line.color == 2 ? 1 : 0));
                if (next.red > redLim || next.blue > blueLim) continue;
                if (!dist.containsKey(next.str) || dist.get(cur.str) + line.cost < dist.get(next.str)) {
                    dist.put(next.str, dist.get(cur.str) + line.cost);
                    if (!visited.contains(next.str)) {
                        queue.add(next);
                        visited.add(next.str);
                    }
                }
            }
        }

        cur = new QueueNode(end, redLim, blueLim);
        if (!dist.containsKey(cur.str))
            System.out.println(-1);
        else System.out.println(dist.get(cur.str));
    }
}
