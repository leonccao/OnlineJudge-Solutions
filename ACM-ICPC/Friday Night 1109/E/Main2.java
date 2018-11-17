import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static class Degree {
        int city, degree, outdegree;
        public Degree(int city) {
            this.city = city;
            degree = 0;
            outdegree = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        Degree[] degrees = new Degree[n];
        for (int i = 0; i < n; i ++)
            degrees[i] = new Degree(i);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i ++)
            graph.put(i, new ArrayList<>());
        for (int i = 0; i < m; i ++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            degrees[b].degree ++;
            degrees[a].outdegree ++;
            graph.get(a).add(b);
        }
        degrees[start - 1].degree = -1;
        Arrays.sort(degrees, (a, b) -> {
            if (a.degree != b.degree)
                return a.degree - b.degree;
            else return b.outdegree - a.outdegree;
        });

        Set<Integer> visited = new HashSet<>();
        int ans = -1, count = 0;
        while (visited.size() < n) {
            int cur = degrees[count ++].city;
            if (visited.contains(cur)) continue;
            ans ++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(cur);
            visited.add(cur);
            while (!queue.isEmpty()) {
                int tmp = queue.poll();
                List<Integer> nbs = graph.get(tmp);
                for (int nb : nbs) {
                    if (visited.contains(nb)) continue;
                    queue.add(nb);
                    visited.add(nb);
                }
            }
        }
        System.out.println(ans);

        sc.close();
    }
}

