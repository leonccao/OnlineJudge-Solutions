class Solution {
    
    public int mz(int x) {
        return Math.max(x, 0);
    }
    
    public double soupServings(int N) {
        N = (N + 24) / 25;
        if (N > 500) return 1;
        
        double[][] p = new double[N + 1][N + 1];
        for (int i = 1; i <= N; i ++)
            p[0][i] = 1;
        p[0][0] = 0.5;
        
        for (int i = 1; i <= N; i ++)
            for (int j = 1; j <= N; j ++) {
                p[i][j] += 0.25 * p[mz(i - 4)][mz(j)];
                p[i][j] += 0.25 * p[mz(i - 3)][mz(j - 1)];
                p[i][j] += 0.25 * p[mz(i - 2)][mz(j - 2)];
                p[i][j] += 0.25 * p[mz(i - 1)][mz(j - 3)];
            }
        return p[N][N];
    }
}