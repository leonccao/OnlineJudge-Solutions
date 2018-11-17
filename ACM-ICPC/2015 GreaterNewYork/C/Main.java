import java.util.*;

public class Main {

    final static int MOD = 1000000000;

    final static int[][] FIB = {{0, 1}, {1, 1}};
    final static int[] START = {0, 1};

    private static int[][] mult(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i ++)
        for (int j = 0; j < n; j ++)
        for (int k = 0; k < n; k ++)
            c[i][j] = (int)(((long)c[i][j] + (long)a[i][k] * b[k][j]) % MOD);
        return c;
    }

    private static int[][] helper(long n) {
        if (n == 1) return FIB;
        int[][] tmp = helper(n >> 1);
        tmp = mult(tmp, tmp);
        if ((n & 1) != 0) tmp = mult(tmp, FIB);
        return tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            int id = sc.nextInt();
            long n = sc.nextLong();
            int[][] tmp = helper(n);
            System.out.println(id + " " + tmp[1][0]);
        }
    }
}
