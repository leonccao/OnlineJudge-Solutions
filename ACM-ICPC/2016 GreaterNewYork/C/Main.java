import java.util.*;

public class Main {

    final static int LIMIT = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<List<Integer>> POW = new ArrayList<>();
        POW.add(new ArrayList<>());
        POW.add(new ArrayList<>());
        POW.add(new ArrayList<>());
        for (int i = 3; i <= 100; i ++) {
            POW.add(new ArrayList<>());
            int tmp = 1;
            for (int j = 0; j < 10; j ++) {
                POW.get(i).add(tmp);
                tmp *= i;
                if (tmp > LIMIT) break;
            }
        }

        int t = sc.nextInt();
        while (t -- > 0) {
            int id = sc.nextInt();
            int m = sc.nextInt();
            int n = sc.nextInt();

            int len = POW.get(m).size();
            long[][] f = new long[n + 1][len + 1];
            f[0][0] = 1;
            for (int i = 1; i <= n; i ++) {
                for (int j = 0; j < len; j ++) {
                    if (i - POW.get(m).get(j) < 0) break;
                    for (int k = 0; k <= j; k ++)
                        f[i][j] += f[i - POW.get(m).get(j)][k];
                }
            }

            long ans = 0;
            for (int j = 0; j < len; j ++)
                ans += f[n][j];
            System.out.println(id + " " + ans);
        }

    }
}
