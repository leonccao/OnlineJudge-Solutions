class Solution {
    public int integerBreak(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i < n; i ++)
            f[i] = i;
        for (int i = 2; i <= n; i ++)
            for (int j = 1; j < i; j ++)
                f[i] = Math.max(f[i], f[i - j] * j);
        
        return f[n];
    }
}