import java.util.*;

public class StringPermutation {

    public List<String> permutation(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        List<String> ans = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        helper(0, new StringBuilder(), letters, used, ans);
        return ans;
    }

    private void helper(int index, StringBuilder sb, char[] letters, Set<Integer> used, List<String> ans) {
        if (index == letters.length) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < letters.length; i ++) {
            if (used.contains(i)) continue;
            if (i > 0 && letters[i] == letters[i - 1] & !used.contains(i - 1)) continue;

            used.add(i);    sb.append(letters[i]);
            helper(index + 1, sb, letters, used, ans);
            used.remove(i); sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        StringPermutation sol = new StringPermutation();
        String input = "cbaa";
        List<String> ans = sol.permutation(input);
        for (String s : ans)
            System.out.println(s);
    }
}