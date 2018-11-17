import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        String s = sc.next();
        if (command.equals("E")) {
            StringBuilder sb = new StringBuilder();
            s = s + "$";
            char last = '$';
            int cnt = 0;
            for (char ch : s.toCharArray()) {
                if (ch == last) cnt ++;
                else {
                    if (last != '$') {
                        sb.append(last);
                        sb.append(cnt);
                    }
                    last = ch;
                    cnt = 1;
                }
            }
            System.out.println(sb.toString());
        } else {
            StringBuilder sb = new StringBuilder();
            char last = '$';
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    int cnt = ch - '0';
                    for (int i = 0; i < cnt; i ++)
                        sb.append(last);
                } else last = ch;
            }
            System.out.println(sb.toString());
        }
    }
}
