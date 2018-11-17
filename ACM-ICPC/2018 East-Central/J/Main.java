import java.util.*;

public class Main {

    static boolean[][] e;

    private static int bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < e.length; i ++) {
                if (!e[cur][i] || visited.contains(i)) continue;
                visited.add(i);
                queue.add(i);
            }
        }
        return visited.size() - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        e = new boolean[n][n];
        int ans = 0;
        for (int i = 0; i < n; i ++)
        for (int j = 0; j < n; j ++) {
            String s = sc.next();
            if (s.equals("1")) {
                e[i][j] = true;
                ans --;
            }
            else e[i][j] = false;
        }

        for (int i = 0; i < n; i ++)
            ans += bfs(i);
        System.out.println(ans);
    }
}
