import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            int id = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(id + " " + ((n + 3) * n / 2));
        }
    }
}
