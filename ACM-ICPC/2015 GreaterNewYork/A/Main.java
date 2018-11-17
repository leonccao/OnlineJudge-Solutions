import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i ++) {
            int num = sc.nextInt();
            int n = sc.nextInt();
            int a = (1 + n) * n / 2;
            int b = (2 * n) * n / 2;
            int c = (2 + 2 * n) * n / 2;
            System.out.println(num + " " + a + " " + b + " " + c);
        }
    }
}
