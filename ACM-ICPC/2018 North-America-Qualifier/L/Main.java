import java.util.*;

public class Main {

    private static int n, k;

    private static int[][] s;
    private static boolean[][] cols;
    private static boolean[] visited;

    private static boolean input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        s = new int[n][n];
        cols = new boolean[n][n + 1];
        for (int i = 0; i < k; i ++) {
            boolean[] row = new boolean[n + 1];
            for (int j = 0; j < n; j ++) {
                s[i][j] = sc.nextInt();
                if (cols[j][s[i][j]]) return false;
                if (row[s[i][j]]) return false;
                cols[j][s[i][j]] = true;
                row[s[i][j]] = true;
            }
        }
        return true;
    }

    private static boolean hungarian(int r, int num) {
        for (int i = 0; i < n; i ++) {
            if (cols[i][num] || visited[i]) continue;
            visited[i] = true;
            if (s[r][i] == 0 || hungarian(r, s[r][i])) {
                if (s[r][i] > 0) cols[i][s[r][i]] = false;
                s[r][i] = num;
                cols[i][num] = true;
                return true;
            }
        }
        return false;
    }

    private static void match(int r) {
        for (int i = 1; i <= n; i ++) {
            visited = new boolean[n + 1];
            hungarian(r, i);
        }
    }

    private static void output() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n - 1; j ++)
                System.out.print(s[i][j] + " ");
            System.out.println(s[i][n - 1]);
        }
    }

    public static void main(String[] args) {
        if (input()) System.out.println("yes");
        else {
            System.out.println("no");
            return;
        }
        for (int i = k; i < n; i ++) match(i);
        output();
    }
}
