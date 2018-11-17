import java.util.*;

public class Main {

    final static int MAXN = 200;
    final static int MAXS = 100 + 5;
    static long[][] c = new long[MAXN][MAXN];
    static long[] ans = new long[MAXN];

    private static void init() {
        c[0][0] = c[1][0] = c[1][1] = 1;
        for (int i = 2; i < MAXN; i ++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j ++)
                c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
        }
    }

    public static void main(String[] args) {
        init();
        for (int s = 2; s <= 100; s += 2) {
            int b = s;
            if (s % 6 > 0) b += 6 - s % 6;
            b /= 6;
            for (; b * 4 <= s; b ++) {
                int a = s / 2 - 2 * b;
                ans[s] += c[a + b][a] * c[a + b][a];
            }
        }
        /*
        for (int s = 2; s <= 100; s += 2)
            System.out.println(ans[s]);
        */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            int id = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(id + " " + ans[n]);
        }
    }
}
