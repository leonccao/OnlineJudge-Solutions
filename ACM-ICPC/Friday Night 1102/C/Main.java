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

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            int[] row = new int[n];
            int[] col = new int[n];
            for (int i = 0; i < n; i ++)
                for (int j = 0; j < n; j ++) {
                    int tmp = sc.nextInt();
                    row[i] += tmp;
                    col[j] += tmp;
                }
            int cntRow = 0, cntCol = 0;
            int lastRow = -1, lastCol = -1;
            for (int i = 0; i < n; i ++) {
                if (row[i] % 2 == 1) {
                    cntRow ++;
                    lastRow = i + 1;
                }
                if (col[i] % 2 == 1) {
                    cntCol ++;
                    lastCol = i + 1;
                }
            }
            if (cntRow + cntCol == 0) {
                out.println("OK");
                continue;
            }
            if (cntRow == 1 && cntCol == 1) {
                out.println("Change bit (" + lastRow + "," + lastCol + ")");
                continue;
            }
            out.println("Corrupt");
        }

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