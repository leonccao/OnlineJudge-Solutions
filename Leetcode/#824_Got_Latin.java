class Solution {
    public boolean vowel(char ch) {
        if (ch == 'a' || ch == 'A') return true;
        if (ch == 'e' || ch == 'E') return true;
        if (ch == 'i' || ch == 'I') return true;
        if (ch == 'o' || ch == 'O') return true;
        if (ch == 'u' || ch == 'U') return true;
        return false;
    }
    
    public String toGoatLatin(String S) {
        String[] s = S.trim().split("\\s");
        for (int i = 0; i < s.length; i ++) {
            StringBuilder tmp = new StringBuilder(s[i]);
            if (!vowel(tmp.charAt(0))) {
                char ch = tmp.charAt(0);
                tmp.deleteCharAt(0);
                tmp.append(ch);
            }
            tmp.append("ma");
            for (int cnt = 0; cnt <= i; cnt ++)
                tmp.append('a');
            s[i] = tmp.toString();
        }
        
        StringBuilder ans = new StringBuilder(s[0]);
        for (int i = 1; i < s.length; i ++) {
            ans.append(" ");
            ans.append(s[i]);
        }
        return ans.toString();
    }
}