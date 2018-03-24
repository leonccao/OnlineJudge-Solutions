class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] f = new boolean[s3.length() + 1][s1.length() + 1];
        if (s3.equals(s1 + s2)) return true;
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.equals("") || s1.length() == 0) return false;
        if (s2.equals("") || s2.length() == 0) return false;
        if (s3.equals("") || s3.length() == 0) return false;
        
        if (s1.charAt(0) == s3.charAt(0)) f[1][1] = true;
        if (s2.charAt(0) == s3.charAt(0)) f[1][0] = true;
        
        for (int i = 1; i < s3.length(); i ++) {
            for (int j = -1; j <= i; j ++) {
                if (j == s1.length()) break;
                if (i - j > s2.length()) continue;
                if (j > -1)
                    if (s3.charAt(i) == s1.charAt(j))
                        if (f[i][j])
                            f[i + 1][j + 1] = true;
                if (i - j > 0)
                    if (s3.charAt(i) == s2.charAt(i - j - 1))
                        if (f[i][j + 1])
                            f[i + 1][j + 1] = true;
                // System.out.println((i + 1) + " " + (j + 1) + " " + f[i + 1][j + 1]);
            }
        }
        return f[s3.length()][s1.length()];
    }
}