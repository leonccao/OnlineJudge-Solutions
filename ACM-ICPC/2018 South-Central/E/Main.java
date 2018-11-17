import java.util.*;

public class Main {

    static int[] x, y, r;

    private static double distance(int a, int b) {
        int dx = x[a] - x[b];
        int dy = y[a] - y[b];
        return Math.sqrt(dx * dx + dy * dy) - r[a] - r[b];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        r = new int[n];
        for (int i = 0; i < n; i ++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        double[][] dist = new double[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = i + 1; j < n; j ++)
                dist[i][j] = dist[j][i] = distance(i, j);

        Set<Integer> visited = new HashSet<>();
        double[] key = new double[n];
        Arrays.fill(key, Double.MAX_VALUE);
        key[0] = 0;
        double ans = 0;
        for (int i = 0; i < n; i ++) {
            double min = Double.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < n; j ++)
                if (!visited.contains(j) && key[j] < min) {
                    min = key[j];
                    index = j;
                }
            visited.add(index);
            ans += min;

            for (int j = 0; j < n; j ++)
                if (!visited.contains(j))
                    key[j] = Math.min(key[j], dist[index][j]);
        }
        System.out.println(ans);
    }
}
