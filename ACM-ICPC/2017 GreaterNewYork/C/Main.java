import java.util.*;

public class Main {

    final static int[][] MV = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    static Scanner sc;
    static int id, n, m, k;
    static int x, y;
    static int[][] s;
    static int[] size;
    static List<Set<Integer>> blocks;
    static Map<List<Integer>, Integer> map;

    private static void input() {
        id = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        s = new int[n][m];
        for (int i = 0; i < n; i ++)
        for (int j = 0; j < m; j ++) {
            String t = sc.next();
            if (t.equals("-"))
                s[i][j] = 0;
            else s[i][j] = t.charAt(0) - '0';
        }
        k = sc.nextInt();
        size = new int[k];
        blocks = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 0; i < k; i ++) {
            blocks.add(new HashSet<>());
            size[i] = sc.nextInt();
            for (int j = 0; j < size[i]; j ++) {
                String t = sc.next();
                int a = t.charAt(1) - '1';
                int b = t.charAt(3) - '1';
                map.put(Arrays.asList(a, b), i);
            }
        }
        for (int i = 0; i < n; i ++)
        for (int j = 0; j < m; j ++) {
            if (s[i][j] == 0) continue;
            blocks.get(map.get(Arrays.asList(i, j))).add(s[i][j]);
        }
    }

    private static void find() {
        x = y = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++)
        for (int j = 0; j < m; j ++) {
            if (s[i][j] != 0) continue;

            int tmp = map.get(Arrays.asList(i, j));
            int cnt = size[tmp] - blocks.get(tmp).size();
            if (cnt < min) {
                min = cnt;
                x = i; y = j;
            }
        }
    }

    private static boolean search() {
        find();
        if (x == -1) return true;
        int a = x, b = y;
        int blk = map.get(Arrays.asList(a, b));
        Set<Integer> block = blocks.get(blk);
        int limit = size[blk];

        OUTER_LOOP:
        for (int i = 1; i <= limit; i ++) {
            if (block.contains(i)) continue;
            for (int[] mv : MV) {
                int dx = a + mv[0];
                int dy = b + mv[1];
                if (dx < 0 || dx == n) continue;
                if (dy < 0 || dy == m) continue;
                if (s[dx][dy] == 0) continue;
                if (s[dx][dy] == i) continue OUTER_LOOP;
            }
            s[a][b] = i;
            block.add(i);
            if (search()) return true;
            block.remove(i);
            s[a][b] = 0;
        }
        return false;
    }

    private static void output() {
        System.out.println(id);
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m - 1; j ++)
                System.out.print(s[i][j] + " ");
            System.out.println(s[i][m - 1]);
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            input();
            search();
            output();
        }
    }
}
