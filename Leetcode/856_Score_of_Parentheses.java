class Solution {
    public int scoreOfParentheses(String S) {
        int len = S.length();
        int[][] f = new int[len][len];
        
        for (int i = 0; i < len - 1; i ++)
            if (S.charAt(i) == '(' && S.charAt(i + 1) == ')')
                f[i][i + 1] = 1;
            else f[i][i + 1] = -1;
        
        for (int i = len - 1; i >= 0; i --)
            for (int j = i + 3; j < len; j ++) {
                if ((j - i) % 2 != 1) continue;
                if (S.charAt(i) == '(' && S.charAt(j) == ')'
                   && f[i + 1][j - 1] > 0)
                    f[i][j] = f[i + 1][j - 1] * 2;
                else {
                    for (int k = i + 1; k < j; k ++) {
                        if ((k - i) % 2 != 1) continue;
                        if (f[i][k] <= 0) continue;
                        if (f[k + 1][j] <= 0) continue;
                        f[i][j] = f[i][k] + f[k + 1][j];
                        break;
                    }
                    if (f[i][j] <= 0) f[i][j] = -1;
                }
            }
        return f[0][len - 1];
    }
}