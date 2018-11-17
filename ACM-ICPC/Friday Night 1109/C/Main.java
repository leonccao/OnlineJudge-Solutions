import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();
        int[] ans = new int[n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++)
                ans[i] = ans[i] | matrix[i][j];
        }
        for (int i = 0; i < n - 1; i ++)
            System.out.print(ans[i] + " ");
        System.out.println(ans[n - 1]);

        sc.close();
    }
}

