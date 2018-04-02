class Solution {
    public int minCut(String s) {
        if (s.equals("") || s.length() == 0) return 0;
        
        boolean[][] p = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i ++)
            p[i][i] = true;
        for (int i = 1; i < s.length(); i ++)
            if (s.charAt(i - 1) == s.charAt(i))
                p[i - 1][i] = true;
        for (int i = s.length() - 3; i > -1; i --)
            for (int j = i + 2; j < s.length(); j ++)
                if (p[i + 1][j - 1])
                    if (s.charAt(i) == s.charAt(j))
                        p[i][j] = true;
        
        int[] f = new int[s.length()];
        for (int i = 0; i < s.length(); i ++) {
            if (p[0][i]) {
                f[i] = 0;
                continue;
            }
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j ++)
                if (p[j + 1][i])
                    f[i] = Math.min(f[i], f[j] + 1);
        }
        return f[s.length() - 1];
    }
}