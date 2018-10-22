public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        if (words.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; i --) {
            sb.append(words[i]);
            sb.append(' ');
        }
        sb.append(words[0]);
        return sb.toString();
    }
}