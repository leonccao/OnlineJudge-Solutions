import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int time = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i ++) {
            int cur = sc.nextInt();
            time -= cur;
            if (time >= 0) ans ++;
        }
        System.out.println(ans);

        sc.close();
    }
}

