class Solution {
    public int countHousePlacements(int n) {
        long MOD = 1000000000 + 7;
        long[][] ways = new long[n + 1][2];
        ways[0][0] = 1;
        ways[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            ways[i][0] = (ways[i - 1][0] + ways[i - 1][1]) % MOD;
            ways[i][1] = ways[i - 1][0];
        }
        long cnt = (ways[n][0] + ways[n][1]) % MOD;
        long result = (long)cnt * cnt % MOD;
        return (int)result;
    }
}