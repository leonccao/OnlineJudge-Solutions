class Solution {
    
    final static int MOD = 1000000000 + 7;
    
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] f = new int[m][n][k];
        int temp = grid[0][0] % k;
        f[0][0][temp] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    for (int d = 0; d < k; d++) {
                        int nd = (d + grid[i][j]) % k;
                        f[i][j][nd] = (f[i][j][nd] + f[i - 1][j][d]) % MOD;
                    }
                }
                if (j > 0) {
                    for (int d = 0; d < k; d++) {
                        int nd = (d + grid[i][j]) % k;
                        f[i][j][nd] = (f[i][j][nd] + f[i][j - 1][d]) % MOD;
                    }
                }
            }
        }
        return f[m - 1][n - 1][0];
    }
}