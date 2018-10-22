class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0 || s.equals("")) return "";
        
        Set<Character> set = new HashSet<Character>();
        char st = s.charAt(0);
        int pos = -1;
        for (int i = s.length() - 1; i >= 0; i --) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                st = ch;
            }
            if (ch <= st) {
                st = ch;
                pos = i;
            }
        }
        
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1, s.length()).replaceAll("" + s.charAt(pos), ""));
    }
}