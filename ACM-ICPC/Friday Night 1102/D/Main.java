import java.io.*;
import java.util.*;
 
 
public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        
        // Start writing your solution here. -------------------------------------
    
        /*
        int n      = sc.nextInt();        // read input as integer
        long k     = sc.nextLong();       // read input as long
        double d   = sc.nextDouble();     // read input as double
        String str = sc.next();           // read input as String
        String s   = sc.nextLine();       // read whole line as String

        int result = 3*n;
        out.println(result);                    // print via PrintWriter
        */

        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < m; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (!graph.containsKey(a)) graph.put(a, new ArrayList<>());
            graph.get(a).add(b);
            if (!graph.containsKey(b)) graph.put(b, new ArrayList<>());
            graph.get(b).add(a);
        }

        int color = -1;
        Map<Integer, Boolean> cycle = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i ++) {
            if (visited.contains(i)) continue;
            queue.add(i); visited.add(i);
            cycle.put(++ color, true);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (!graph.containsKey(cur)) {
                    cycle.put(color, false);
                    continue;
                }
                List<Integer> nbs = graph.get(cur);
                if (nbs.size() != 2) cycle.put(color, false);
                for (int nb : nbs) {
                    if (visited.contains(nb)) continue;
                    queue.add(nb); visited.add(nb);
                }
            }
        }

        int ans = 0;
        for (int key : cycle.keySet())
            if (cycle.get(key) == true)
                ans ++;

        out.println(ans);

        // Stop writing your solution here. -------------------------------------
        out.close();
    }

     

   //-----------PrintWriter for faster output---------------------------------
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
    //--------------------------------------------------------
}