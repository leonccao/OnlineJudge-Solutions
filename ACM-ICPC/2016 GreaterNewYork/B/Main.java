import java.util.*;

public class Main {

    final static String INDEX = "0123456789ACDEFHJKLMNPRTVWX";
    final static int[] BASE = {2, 4, 5, 7, 8, 10, 11, 13};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Character, Character> map = new HashMap<>();
        map.put('B', '8');
        map.put('G', 'C');
        map.put('I', '1');
        map.put('O', '0');
        map.put('Q', '0');
        map.put('S', '5');
        map.put('U', 'V');
        map.put('Y', 'V');
        map.put('Z', '2');

        int t = sc.nextInt();
        while (t -- > 0) {
            int id = sc.nextInt();
            String s = sc.next();
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < sb.length(); i ++) {
                char ch = sb.charAt(i);
                if (map.containsKey(ch))
                    sb.setCharAt(i, map.get(ch));
            }

            int sum = 0;
            long ans = 0;
            for (int i = 0; i < 8; i ++) {
                char ch = sb.charAt(i);
                int tmp = INDEX.indexOf("" + ch);
                sum += BASE[i] * tmp;
                ans = ans * 27 + tmp;
            }
            sum %= 27;

            if (sum != INDEX.indexOf("" + sb.charAt(8)))
                System.out.println(id + " Invalid");
            else System.out.println(id + " " + ans);

        }
    }
}
