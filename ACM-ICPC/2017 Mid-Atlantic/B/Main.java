import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int b = sc.nextInt();
        int start = sc.nextInt() - 1;
        int end = sc.nextInt() - 1;
        int[][][] locks = new int[n][n][2];
        int[] badges = new int[l * 2];
        int cnt = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i ++)
            graph.put(i, new ArrayList<>());
        for (int i = 0; i < l; i ++) {
            int p = sc.nextInt() - 1;
            int q = sc.nextInt() - 1;
            graph.get(p).add(q);
            locks[p][q][0] = sc.nextInt();
            locks[p][q][1] = sc.nextInt();
            badges[cnt ++] = locks[p][q][0];
            badges[cnt ++] = locks[p][q][1];
        }
        Arrays.sort(badges);

        int ans = 0, last = 0;
        for (int i = 0; i < badges.length - 1; i ++) {
            last = Math.max(last, badges[i]);
            if (last > badges[i + 1]) continue;
            if (helper(start, end, last, badges[i + 1], graph, locks, new HashSet<>())) {
                ans += badges[i + 1] - last + 1;
                // System.out.println(badges[i] + " " + badges[i + 1]);
                last = badges[i + 1] + 1;
            }
        }
        System.out.println(ans);
        sc.close();
    }

    private static boolean helper(int cur, int end, int x, int y, Map<Integer, List<Integer>> graph, int[][][] locks, Set<Integer> set) {
        if (set.contains(cur)) return false;
        if (cur == end) return true;
        set.add(cur);
        List<Integer> nbs = graph.get(cur);
        for (int nb : nbs) {
            int lx = locks[cur][nb][0];
            int ly = locks[cur][nb][1];
            if (x < lx) continue;
            if (y > ly) continue;
            if (helper(nb, end, x, y, graph, locks, set))
                return true;
        }
        return false;
    }
}