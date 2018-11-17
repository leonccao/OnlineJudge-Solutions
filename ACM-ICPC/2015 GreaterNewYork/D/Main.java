import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxn = 10000;
        int[] phi = new int[maxn + 1];
        phi[1] = 1;
        for (int i = 2; i <= maxn; i ++)
            if (phi[i] == 0)
                for (int j = i; j <= maxn; j += i) {
                    if (phi[j] == 0) phi[j] = j;
                    phi[j] = phi[j] / i * (i - 1);
                }
        int[] rec = new int[maxn + 1];
        phi[0] = rec[0] = 1;
        for (int i = 1; i <= maxn; i ++)
            rec[i] = rec[i - 1] + phi[i];

        int t = sc.nextInt();
        while (t -- > 0) {
            int num = sc.nextInt();
            int n = sc.nextInt();
            /*
            int sum = n * (n - 1) / 2 + 2;
            System.out.println(sum);
            for (int i = 2; i < n; i ++) {
                int m = n / i;
                int tmp = m * (m - 1) / 2;
                sum -= tmp;
            }
            */
            System.out.println(num + " " + rec[n]);
        }
    }
}
