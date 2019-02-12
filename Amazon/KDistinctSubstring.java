import java.util.Set;
import java.util.HashSet;

public class KDistinctSubstring {

    public static int solution(String inputString, int num) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < inputString.length(); i ++) {
            set.clear();
            int cnt = 0;
            for (int j = i; j < inputString.length(); j ++) {
                char ch = inputString.charAt(j);
                if (!set.contains(ch)) {
                    cnt ++;
                    set.add(ch);
                }
                if (cnt > num) break;
                if (cnt == num) ans ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int res = solution("pqpqs", 0);
        System.out.println(res);
    }
}
