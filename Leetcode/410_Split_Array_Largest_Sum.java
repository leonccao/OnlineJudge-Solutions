class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n];
        for (int i = 0; i < n; i ++) {
            sum[i] = nums[i];
            if (i > 0) sum[i] += sum[i - 1];
        }
        
        int[][] f = new int[n][m + 1];
        for (int i = 0; i < n; i ++)
            for (int j = 1; j <= m; j ++)
                f[i][j] = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i ++)
            f[i][1] = sum[i];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < i; j ++)
                for (int k = 1; k <= Math.min(j + 1, m - 1); k ++)
                    f[i][k + 1] = Math.min(
                        Math.max(f[j][k], sum[i] - sum[j]),
                        f[i][k + 1]
                    );
        
        return f[n - 1][m];
    }
}