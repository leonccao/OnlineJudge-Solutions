import java.util.*;

public class Main {

    private static String trans(int[] cnt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i ++) {
            sb.append(cnt[i]);
            sb.append(',');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        OUTER_LOOP:
        for (int i = 0; i < n; i ++) {
            String a = sc.next();
            String b = sc.next();
            //System.out.println(a + " " + b);
            Set<String> set = new HashSet<>();
            for (int l = b.length(); l >= 1; l --) {
                int[] cnt = new int[26];
                for (int j = 0; j < l - 1; j ++) {
                    cnt[b.charAt(j) - 'a'] ++;
                }
                for (int j = l - 1; j < b.length(); j ++) {
                    cnt[b.charAt(j) - 'a'] ++;
                    if (j >= l)
                        cnt[b.charAt(j - l) - 'a'] --;
                    set.add(trans(cnt));
                }
                
                cnt = new int[26];

                for (int j = 0; j < l - 1; j ++) {
                    cnt[a.charAt(j) - 'a'] ++;
                }
                for (int j = l - 1; j < a.length(); j ++) {
                    cnt[a.charAt(j) - 'a'] ++;
                    if (j >= l)
                        cnt[a.charAt(j - l) - 'a'] --;
                    if (set.contains(trans(cnt))) {
                        System.out.println(a.substring(j - l + 1, j + 1));
                        continue OUTER_LOOP;
                    }
                }
            }
            System.out.println("NONE");
        }
    }
}
