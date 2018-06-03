class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] f = new int[1 << n][n];
        int full = 1 << n;
        for (int i = 0; i < full; i ++)
            for (int j = 0; j < n; j ++)
                f[i][j] = Integer.MAX_VALUE - 1;
        
        for (int i = 0; i < n; i ++)
            f[1 << i][i] = 0;
        for (int i = 0; i < full; i ++) {
            boolean update = true;
            while (update) {
                update = false;
                for (int j = 0; j < n; j ++) {
                    if ((i & (1 << j)) == 0) continue;

                    int[] path = graph[j];
                    for (int k : path) {
                        if ((i & (1 << k)) == 0) continue;
                        if (f[i][k] + 1 < f[i][j]) {
                            f[i][j] = f[i][k] + 1;
                            update = true;
                        }
                        if (f[i ^ (1 << j)][k] + 1 < f[i][j]) {
                            f[i][j] = f[i ^ (1 << j)][k] + 1;
                            update = true;
                        }
                    }
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++)
            ans = Math.min(ans, f[full - 1][i]);
        return ans;
    }
}