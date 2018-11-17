import java.util.*;
import java.io.*;

public class Main {

    static int[] father, h, visited;

    private static boolean merge(int a, int b) {
        int fa = get(a);
        int fb = get(b);
        if (fa == fb) return false;
        if (h[fa] > h[fb]) {
            father[fb] = fa;
            h[fa] += h[fb];
        } else {
            father[fa] = fb;
            h[fb] += h[fa];
        }
        return true;
    }

    private static int get(int x) {
        if (father[x] == x) return x;
        father[x] = get(father[x]);
        return father[x];
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        while (t -- > 0)  {
            /*
             * input
             */
            int id = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean[][] s = new boolean[n][m];
            for (int i = 0; i < n; i ++) {
                String st = sc.next();
                for (int j = 0; j < m; j ++)
                    s[i][j] = st.charAt(j) == '1';
            }

            /*
             * prepare
             */
            father = new int[n * m];
            h = new int[n * m];
            visited = new int[n * m];
            for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++) {
                int tmp = i * m + j;
                father[tmp] = tmp;
                h[tmp] = 1;
            }

            // left to right
            int[] left = new int[m];
            int[] lb = new int[m];
            int[] lw = new int[m];
            int white = 0, black = 0;
            for (int j = 0; j < m - 1; j ++) {
                for (int i = 0; i < n; i ++) {
                    visited[i * m + j] = -1;
                    if (s[i][j]) black ++; else white ++;
                    if (j > 0) {
                        if (s[i][j] == s[i][j - 1]
                            && merge(i * m + j, i * m + j - 1)) {
                                if (s[i][j]) black --; else white --;
                            }
                    }
                    if (i > 0) {
                        if (s[i][j] == s[i - 1][j]
                            && merge(i * m + j, (i - 1) * m + j)) {
                                if (s[i][j]) black --; else white --;
                            }
                    }
                }
                for (int i = 0; i < n; i ++) {
                    if (!s[i][j]) continue;
                    int fa = get(i * m + j);
                    if (visited[fa] != j) {
                        left[j + 1] ++;
                        visited[fa] = j;
                    }
                }
                lw[j + 1] = white;
                lb[j + 1] = black;
            }

            for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++) {
                int tmp = i * m + j;
                father[tmp] = tmp;
                h[tmp] = 1;
            }

            // right to left
            int[] right = new int[m];
            int[] rw = new int[m];
            int[] rb = new int[m];
            white = black = 0;
            for (int j = m - 1; j > 0; j --) {
                for (int i = 0; i < n; i ++) {
                    visited[i * m + j] = -1;
                    if (s[i][j]) black ++; else white ++;
                    if (j < m - 1) {
                        if (s[i][j] == s[i][j + 1]
                            && merge(i * m + j, i * m + j + 1)) {
                                if (s[i][j]) black --; else white --;
                            }
                    }
                    if (i > 0) {
                        if (s[i][j] == s[i - 1][j]
                            && merge(i * m + j, (i - 1) * m + j)) {
                                if (s[i][j]) black --; else white --;
                            }
                    }
                }
                for (int i = 0; i < n; i ++) {
                    if (!s[i][j]) continue;
                    int fa = get(i * m + j);
                    if (visited[fa] != j) {
                        right[j - 1] ++;
                        visited[fa] = j;
                    }
                }
                rw[j - 1] = white;
                rb[j - 1] = black;
            }

            int ans = Integer.MIN_VALUE, ab = 0, aw = 0;
            for (int j = 0; j < m; j ++) {
                int tmpBlack = lb[j] + rb[j] + 1 - left[j] - right[j];
                int tmpAll = tmpBlack + lw[j] + rw[j];
                if (tmpAll > ans || (tmpAll == ans && tmpBlack < ab)) {
                    ans = tmpAll;
                    ab = tmpBlack;
                    aw = tmpAll - tmpBlack;
                }
            }
            out.println(id + " " + aw + " " + ab);
            out.close();
        }
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
