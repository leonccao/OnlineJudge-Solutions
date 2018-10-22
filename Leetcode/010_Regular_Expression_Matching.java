class Solution {
    public boolean isMatch(String s, String p) {
        // if s and p are same
        if (s.equals(p)) return true;
        // if p is null
        if (p.length() == 0 || p.equals(null)) return false;
        
        s = "$" + s;
        p = "$" + p;
        boolean[][] f = new boolean[s.length()][p.length()];
        f[0][0] = true;
        for (int i = 0; i < s.length(); i ++) {
            char last = '$', chs = s.charAt(i);
            for (int j = 1; j < p.length(); j ++) {
                char chp = p.charAt(j);
                if (Character.isLetter(chp)) {
                    if (i > 0 && chp == chs)
                        f[i][j] = f[i - 1][j - 1];
                } else if (chp == '.') {
                    if (i > 0)
                        f[i][j] = f[i - 1][j - 1];
                } else if (chp == '*') {
                    if (i > 0 && (last == chs || last == '.'))
                        f[i][j] = f[i - 1][j];
                    if (f[i][j - 2]) f[i][j] = true;
                }
                last = chp;
            }
        }
        return f[s.length() - 1][p.length() - 1];
    }
}