class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals(t)) return true;
        if (t.equals("") || t.length() == 0) return false;
        if (s.equals("") || s.length() == 0) return true;
        int[] match = new int[t.length()];
        if (t.charAt(0) == s.charAt(0))
            match[0] = 0;
        else match[0] = -1;
        
        for (int i = 1; i < t.length(); i ++) {
            char ch = s.charAt(match[i - 1] + 1);
            if (t.charAt(i) == ch)
                match[i] = match[i - 1] + 1;
            else match[i] = match[i - 1];
            if (match[i] == s.length() - 1)
                return true;
        }
        return false;
    }
}