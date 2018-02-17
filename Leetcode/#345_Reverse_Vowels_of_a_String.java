class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int back = sb.length() - 1;
        for (int i = 0; i < back; i ++) {
            if (!vowel(sb.charAt(i))) continue;
            while (!vowel(sb.charAt(back))) back --;
            if (back == i) break;
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(back));
            sb.setCharAt(back --, tmp);
        }
        return sb.toString();
    }
    
    public boolean vowel(char ch) {
        if (ch == 'a' || ch == 'A') return true;
        if (ch == 'e' || ch == 'E') return true;
        if (ch == 'i' || ch == 'I') return true;
        if (ch == 'o' || ch == 'O') return true;
        if (ch == 'u' || ch == 'U') return true;
        return false;
    }
}