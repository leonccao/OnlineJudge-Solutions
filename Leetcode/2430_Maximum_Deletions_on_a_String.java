class Solution {
    public int deleteString(String s) {
        int n = s.length();
        
        int[][] match = new int[n + 1][n + 1];
        for (int j = n - 1; j >= 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    match[i][j] = match[i + 1][j + 1] + 1;
                }
            }
        }
        
        int[] f = new int[n + 1];
        int result = 0;
        for (int i = 0; i < n; i++) {
            f[i] = Integer.MIN_VALUE;
        }
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (match[j][i] >= i - j) {
                   f[i] = Math.max(f[i], f[j] + 1); 
                }
            }
            result = Math.max(result, f[i]);
        }
        return result + 1;
    }
}