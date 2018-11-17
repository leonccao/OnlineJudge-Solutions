import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        BigInteger MOD = BigInteger.ONE;
        for (int i = 0; i < s.length(); i ++)
            MOD = MOD.multiply(BigInteger.TEN);

        Queue<String> queue = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();
        Queue<Integer> lastBit = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(s); dist.add(0); lastBit.add(0); set.add(s);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int curDist = dist.poll();
            int last = lastBit.poll();
            if (isPalindrom(cur)) {
                System.out.println(curDist);
                sc.close();
                return;
            }

            BigInteger plus = BigInteger.ONE;
            for (int i = 0; i < last; i ++)
                plus = plus.multiply(BigInteger.TEN);
            for (int i = last; i < cur.length(); i ++) {
                String next = add(cur, plus, MOD);
                plus = plus.multiply(BigInteger.TEN);
                if (set.contains(next)) continue;
                if (next.charAt(s.length() - i - 1) == s.charAt(s.length() - i - 1)) continue;
                queue.add(next); dist.add(curDist + 1); lastBit.add(i); set.add(next);
            }
        }
        System.out.println(-1);
        sc.close();
    }

    private static String add(String s, BigInteger plus, BigInteger MOD) {
        BigInteger n = new BigInteger(s);
        n = n.add(plus);
        n = n.mod(MOD);
        String rtn = n.toString();
        while (rtn.length() < s.length())
            rtn = "0" + rtn;
        return rtn;
    }

    private static boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i ++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        return true;
    }
}