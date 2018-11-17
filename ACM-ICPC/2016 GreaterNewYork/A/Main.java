import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            int id = sc.nextInt();
            int n = sc.nextInt();

            Integer num = new Integer(n);
            String s = num.toString();
            int oct = 0, hex = 0;
            int octBase = 1, hexBase = 1;
            boolean octal = true;
            for (int i = s.length() - 1; i >= 0; i --) {
                char ch = s.charAt(i);
                if (ch > '7') {
                    octal = false;
                }
                int tmp = ch - '0';
                if (octal) oct += octBase * tmp;
                hex += hexBase * tmp;
                if (octal) octBase *= 8;
                hexBase *= 16;
            }
            if (!octal) System.out.println(id + " " + 0 + " " + n + " " + hex);
            else System.out.println(id + " " + oct + " " + n + " " + hex);
        }
    }
}
