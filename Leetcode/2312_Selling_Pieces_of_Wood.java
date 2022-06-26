class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] maxs = new long[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                maxs[i][j] = Long.MIN_VALUE;
            }
        }
        for (int[] price : prices) {
            int h = price[0];
            int w = price[1];
            int p = price[2];
            maxs[h][w] = p;
        }
        
        for (int i = 0; i <= m; i ++) {
            maxs[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            maxs[0][j] = 0;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                maxs[i][j] = Math.max(maxs[i][j], maxs[i - 1][j]);
                maxs[i][j] = Math.max(maxs[i][j], maxs[i][j - 1]);
                
                for (int k = 1; k < i; k++) {
                    long temp = maxs[k][j] + maxs[i - k][j]; 
                    maxs[i][j] = Math.max(maxs[i][j], temp);
                }
                
                for (int k = 1; k < j; k++) {
                    long temp = maxs[i][k] + maxs[i][j - k]; 
                    maxs[i][j] = Math.max(maxs[i][j], temp);
                }
            }
        }
        return maxs[m][n];
    }
}