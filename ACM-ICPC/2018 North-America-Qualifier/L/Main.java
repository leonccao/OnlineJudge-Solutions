import java.util.*;

public class Main {

    private static int n, k;
    private static int[][] s;
    private static boolean[][] col, row;

    private static boolean input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        s = new int[n][n];
        col = new boolean[n][n + 1];
        for (int i = 0; i < k; i ++) {
            boolean[] row = new boolean[n + 1];
            for (int j = 0; j < n; j ++) {
                int tmp = sc.nextInt();
                s[i][j] = tmp;
                if (col[j][tmp]) return false;
                col[j][tmp] = true;
                if (row[tmp]) return false;
                row[tmp] = true;
            }
        }
        return true;
    }

    private static boolean dfs(int r, int c) {
        if (r == n) return true;
        for (int i = 1; i <= n; i ++) {
            if (col[c][i]) continue;
            if (row[r][i]) continue;
            // System.out.println(r + " " + c + " " + i);
            col[c][i] = true;
            row[r][i] = true;
            // System.out.println(row[3][4]);
            s[r][c] = i;
            if (dfs(r + 1, c)) return true;
            s[r][c] = 0;
            col[c][i] = false;
            row[r][i] = false;
        }
        return false;
    }

    private static void search(int cur) {
        dfs(k, cur);
    }

    private static void output() {
        System.out.println(n);
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n - 1; j ++)
                System.out.print(s[i][j] + " ");
            System.out.println(s[i][n - 1]);
        }
    }

    public static void main(String[] args) {
        if (!input()) {
            System.out.println("no");
            return;
        } else System.out.println("yes");
        row = new boolean[n][n + 1];
        for (int i = 0; i < n; i ++)
            search(i);
        output();
    }
}
