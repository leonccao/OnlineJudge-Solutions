import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            int id = sc.nextInt();
            int base = sc.nextInt();
            long n = sc.nextLong();

            int ans = 0;
            while (n > 0) {
                int tmp = (int)(n % base);
                ans += tmp * tmp;
                n /= base;
            }
            System.out.println(id + " " + ans);
        }
    }
}
