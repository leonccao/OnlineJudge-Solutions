class Solution {
    
    final static int MOD = 1000000000 + 7;
    
    public int knightDialer(int N) {
        long[][] f = new long[10][N];
        for (int i = 0; i < 10; i ++)
            f[i][0] = 1;
        for (int i = 1; i < N; i ++) {
            f[0][i] = (f[4][i - 1] + f[6][i - 1]) % MOD;
            f[1][i] = (f[6][i - 1] + f[8][i - 1]) % MOD;
            f[2][i] = (f[7][i - 1] + f[9][i - 1]) % MOD;
            f[3][i] = (f[4][i - 1] + f[8][i - 1]) % MOD;
            f[4][i] = (f[0][i - 1] + f[3][i - 1] + f[9][i - 1]) % MOD;
            f[6][i] = (f[0][i - 1] + f[1][i - 1] + f[7][i - 1]) % MOD;
            f[7][i] = (f[2][i - 1] + f[6][i - 1]) % MOD;
            f[8][i] = (f[1][i - 1] + f[3][i - 1]) % MOD;
            f[9][i] = (f[2][i - 1] + f[4][i - 1]) % MOD;
        }
        long ans = 0;
        for (int i = 0; i < 10; i ++)
            ans = (ans + f[i][N - 1]) % MOD;
        return (int)ans;
    }
}