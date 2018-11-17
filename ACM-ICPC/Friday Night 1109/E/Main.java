import java.util.*;

public class Main {

    public static int timeStamp = 0, blockCnt = 0;

    private static void tarjan(int cur, int[] dfn, int[] low, int[] block, Stack<Integer> stack, List<Integer>[] graph) {
        dfn[cur] = low[cur] = timeStamp ++;
        stack.add(cur);

        List<Integer> nbs = graph[cur];
        for (int nb : nbs) {
            if (dfn[nb] == -1) {
                tarjan(nb, dfn, low, block, stack, graph);
                low[cur] = Math.min(low[cur], low[nb]);
            } else if (block[nb] == -1)
                low[cur] = Math.min(low[cur], dfn[nb]);
        }
        if (dfn[cur] == low[cur]) {
            blockCnt ++;
            while (true) {
                int tmp = stack.pop();
                block[tmp] = blockCnt - 1;
                if (tmp == cur) break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt() - 1;
        List<Integer>[] graph = (List<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i ++)
            graph[i] = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < m; i ++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            graph[a].add(b);
            degree[b] ++;
        }

        int[] dfn = new int[n];
        int[] block = new int[n];
        Arrays.fill(dfn, -1);
        Arrays.fill(block, -1);
        for (int i = 0; i < n; i ++)
            if (dfn[i] == -1)
                tarjan(i, dfn, new int[n], block, new Stack<>(), graph);

        int[] degreeBlock = new int[blockCnt];
        for (int i = 0; i < n; i ++) {
            List<Integer> nbs = graph[i];
            for (int nb : nbs) {
                if (block[i] != block[nb])
                    degreeBlock[block[nb]] ++;
            }
        }
        int ans = 0;
        for (int i = 0; i < blockCnt; i ++)
            if (degreeBlock[i] == 0)
                ans ++;
        if (degreeBlock[block[start]] == 0) ans --;
        System.out.println(ans);
    }
}
