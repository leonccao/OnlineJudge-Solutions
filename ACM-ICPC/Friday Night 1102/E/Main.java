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
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i ++)
            a[i][0] = sc.nextInt();
        for (int i = 0; i < n; i ++)
            a[i][1] = sc.nextInt();
        long[] sum = new long[n + 1];
        long[][] calc = new long[n + 1][2];
        for (int i = n - 1; i >= 0; i --) {
            long tmp = (n - i) * 2 - 1;
            calc[i][0] = calc[i + 1][0] + sum[i + 1] + tmp * a[i][1];
            calc[i][1] = calc[i + 1][1] + sum[i + 1] + tmp * a[i][0];

            sum[i] = sum[i + 1] + a[i][0] + a[i][1];
            //out.println(calc[i][0] + " " + calc[i][1]);
        }

        long ans = 0, cur = 0;
        for (int i = 0; i < n; i ++) {

            if (i % 2 == 0) {
                if (i > 0) {
                    cur += (long)(i * 2 - 2) * a[i - 1][1] + (long)(i * 2 - 1) * a[i - 1][0];
                }
                long tmp = cur + calc[i][0] + (long)i * 2 * sum[i];
                ans = Math.max(ans, tmp);
            } else {
                cur += (long)(i * 2 - 2) * a[i - 1][0] + (long)(i * 2 - 1) * a[i - 1][1];
                long tmp = cur + calc[i][1] + (long)i * 2 * sum[i];
                ans = Math.max(ans, tmp);
            }
            //out.println(cur);
        }
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