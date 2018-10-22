class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] c = new int[n];
        c[0] = c[n - 1] = 1;
        for (int i = 1; i < n - 1; i ++)
            c[i] = nums[i - 1];
        
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i --)
            for (int j = i + 1; j < n; j ++)
                for (int k = i + 1; k < j; k ++)
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + c[i] * c[k] * c[j]);
        return f[0][n - 1];
    }
}