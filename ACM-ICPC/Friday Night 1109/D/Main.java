import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long b = sc.nextLong();
        int ans = 0;
        for (int i = 1; i < Math.sqrt(b); i ++)
            if (b % i == 0) ans += 2;
        int tmp = (int)Math.sqrt(b);
        if ((long)tmp * tmp == b) ans ++;
        System.out.println(ans);

        sc.close();
    }
}

