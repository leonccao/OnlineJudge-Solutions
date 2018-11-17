import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    private static boolean hungarian(int cur, Set<Integer> visited, int[] match, List<Integer>[] graph) {
        List<Integer> nbs = graph[cur];
        for (int nb : nbs) {
            if (visited.contains(nb)) continue;
            visited.add(nb);
            if (match[nb] == -1 || hungarian(match[nb], visited, match, graph)) {
                match[nb] = cur;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int k = sc.nextInt();
            if (k == 0) break;
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer>[] graph = (List<Integer>[]) new ArrayList[n];
            for (int i = 0; i < n; i ++)
                graph[i] = new ArrayList<>();
            for (int i = 0; i < k; i ++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                graph[a].add(b);
            }

            int[] match = new int[m];
            Arrays.fill(match, -1);
            int ans = 0;
            for (int i = 0; i < n; i ++)
                if (hungarian(i, new HashSet<>(), match, graph))
                    ans ++;

            System.out.println(ans);

        }
        sc.close();
    }
}

