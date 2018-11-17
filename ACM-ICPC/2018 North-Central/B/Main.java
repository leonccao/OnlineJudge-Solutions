import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i ++)
      a[i] = sc.nextInt();

    long ans = Long.MIN_VALUE;
    long[][][] f = new long[2][k + 1][2];
    for (int i = 0; i < 2; i ++)
      for (int j = 0; j < k + 1; j ++) {
        f[i][j][0] = Long.MIN_VALUE / 100;
        f[i][j][1] = Long.MIN_VALUE / 100;
      }
    f[0][0][0] = f[0][0][1] = 0;

    for (int ii = 1; ii < n + 1; ii ++)
      for (int j = 0; j < k + 1; j ++) {
        int i = ii % 2;
        f[i][j][0] = Long.MIN_VALUE / 100;
        f[i][j][1] = Long.MIN_VALUE / 100;
        f[i][j][0] = Math.max(f[1 - i][j][0], f[1 - i][j][1]);
        if (j > 0) {
          f[i][j][1] = f[1 - i][j][1];
          f[i][j][1] = Math.max(f[i][j][1], f[1 - i][j - 1][0]);
          f[i][j][1] = Math.max(f[i][j][1], f[1 - i][j - 1][1]);
        }
        f[i][j][1] += a[ii];
        if (j == k) {
          ans = Math.max(ans, f[i][j][1]);
          ans = Math.max(ans, f[i][j][0]);
        }

        //System.out.println(ii + " " + j + " " + f[i][j][0] + " " + f[i][j][1]);
      }
    System.out.println(ans);
  }
}
