class Solution {
    final static int MOD = 1000000007;
    
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] f = new int[G + 1][P + 1];
        f[0][0] = 1;
        int n = group.length;
        for (int i = 0; i < n; i ++)
            for (int g = G - group[i]; g >= 0; g --)
                for (int p = P; p >= 0; p --) {
                    f[g + group[i]][Math.min(P, p + profit[i])] += f[g][p];
                    f[g + group[i]][Math.min(P, p + profit[i])] %= MOD;
                }
        
        int ans = 0;
        for (int g = 0; g <= G; g ++)
            ans = (ans + f[g][P]) % MOD;
        return ans;
    }
}