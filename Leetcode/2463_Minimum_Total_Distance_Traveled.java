class Solution {
    public long minimumTotalDistance(List<Integer> r, int[][] f) {
        Collections.sort(r);
        Arrays.sort(f, (a, b) -> a[0] - b[0]);
        
        long[][] sum = new long[f.length + 1][r.size() + 1];
        for (int i = 1; i <= f.length; i++) {
            sum[i][0] = 0;
        }
        for (int j = 1; j <= f.length; j++) {
            for (int i = 1; i <= r.size(); i++) {
                sum[j][i] = sum[j][i - 1] + Math.abs(r.get(i - 1) - f[j - 1][0]);
            }
        }
        
        long[][] dp = new long[f.length + 1][r.size() + 1];
        for (int i = 0; i <= f.length; i++) {
            for (int j = 0; j <= r.size(); j++) {
                dp[i][j] = Long.MAX_VALUE / 2;
            }
        }
        dp[0][0] = 0;
        long result = Long.MAX_VALUE;
        for (int i = 1; i <= f.length; i++) {
            for (int j = 0; j <= r.size(); j++) {
                for (int k = j; k >= 0; k--) {
                    if (j - k > f[i - 1][1]) {
                        break;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + sum[i][j] - sum[i][k]);
                }
            }
            result = Math.min(result, dp[i][r.size()]);
        }
        return result;
    }
}