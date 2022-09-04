class Solution {
    
    private final static int MOD = 1000000000 + 7;
    
    public int numberOfWays(int startPos, int endPos, int k) {
        if (Math.abs(startPos - endPos) > k) {
            return 0;
        }
        int sum = k + endPos - startPos;
        if (sum % 2 != 0) {
            return 0;
        }
        int stepRight = sum / 2;
        int stepLeft = k - stepRight;
        int select = Math.min(stepLeft, stepRight);
        
        int[][] f = new int[k + 1][select + 1];
        for (int i = 0; i <= k; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= select; i++) {
            f[i][i] = 1;
        }
        
        for (int i = 1; i <= select; i++) {
            for (int j = i + 1; j <= k; j++) {
                f[j][i] = (int)(((long)f[j - 1][i - 1] + f[j - 1][i]) % MOD);
            }
        }
        
        
        return f[k][select];
    }
}