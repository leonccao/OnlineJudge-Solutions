import java.util.*;
import java.io.*;

public class Main {

    public static class Edge {
        int color, node;
        Edge(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();

        Map<Integer, Set<Edge>> tree = new HashMap<>();
        for (int i = 0; i < n; i ++)
            tree.put(i, new HashSet<>());
        for (int i = 0; i < n - 1; i ++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            if (!tree.containsKey(a)) tree.put(a, new HashSet<>());
            if (!tree.containsKey(b)) tree.put(b, new HashSet<>());
            tree.get(a).add(new Edge(b, c));
            tree.get(b).add(new Edge(a, c));
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            Map<Integer, Integer> map = new HashMap<>();
            Set<Edge> edges = tree.get(i);
            for (Edge edge : edges) 
                map.put(edge.color, map.getOrDefault(edge.color, 0) + 1);

            List<Edge> garbage = new ArrayList<>();
            for (Edge edge : edges) {
                if (map.get(edge.color) == 1) continue;
                queue.add(edge.node);
                visited.put(edge.node, i);
                garbage.add(edge);
            }
            for (Edge edge : garbage)
                edges.remove(edge);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // System.out.println(cur.node + " " + cur.start);
            Set<Edge> edges = tree.get(cur);
            for (Edge edge : edges) {
                if (edge.node == visited.get(cur)) continue;
                if (visited.containsKey(edge.node)) {
                    if (visited.get(cur) != visited.get(edge.node)) {
                        out.println(0);
                        out.close();
                        return;
                    }
                    continue;
                }
                visited.put(edge.node, visited.get(cur));
                queue.add(edge.node);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i ++)
            if (!visited.containsKey(i))
                ans.add(i + 1);
        out.println(ans.size());
        for (int node : ans)
            out.println(node);

        out.close();
    }

    public static PrintWriter out;
        
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
    
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt() {
            return Integer.parseInt(next());
        }
    
        long nextLong() {
            return Long.parseLong(next());
        }
    
        double nextDouble() {
            return Double.parseDouble(next());
        }
    
        String nextLine(){
            String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
        }

    }
}