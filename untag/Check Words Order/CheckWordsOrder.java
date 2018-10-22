import java.util.*;

public class CheckWordsOrder {

    private boolean check(String wa, String wb, Map<Character, Integer> dict) {
        int len = Math.min(wa.length(), wb.length());
        for (int i = 0; i < len; i ++) {
            if (dict.get(wa.charAt(i)) < dict.get(wb.charAt(i))) return true;
            if (dict.get(wa.charAt(i)) > dict.get(wb.charAt(i))) return false;
        }
        if (wa.length() <= wb.length()) return true;
        else return false;
    }

    private boolean checkOrder(String[] words, char[] diction) {
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for (int i = 0; i < diction.length; i ++)
            dict.put(diction[i], i);
        
        for (int i = 0; i < words.length - 1; i ++)
            if (!check(words[i], words[i + 1], dict))
                return false;
        return true;
    }

    public static void main(String[] args) {
        CheckWordsOrder sol = new CheckWordsOrder();
        String[] words = {"a", "aa", "cbc", "cbb"};
        char[] diction = {'a', 'c', 'b'};
        System.out.println(sol.checkOrder(words, diction));
    }
}