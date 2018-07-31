class Solution {
    public boolean stoneGame(int[] piles) {
        int sum = 0, n = piles.length;
        for (int pile : piles)
            sum += pile;
        
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                f[i][j] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++)
            f[i][i] = 0;
        
        for (int i = n - 1; i >= 0; i --)
            for (int j = i + 1; j < n; j ++) {
                if ((j - i + 1) % 2 == 0) 
                    f[i][j] = Math.max(f[i + 1][j] + piles[i], f[i][j - 1] + piles[j]);
                else f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
            }
        if (f[0][n - 1] > sum - f[0][n - 1]) 
            return true;
        return false;
    }
}