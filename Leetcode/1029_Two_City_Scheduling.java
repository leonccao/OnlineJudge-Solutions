// DP

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[][] f = new int[n * 2 + 1][n + 1];
        for (int i = 0; i < n * 2 + 1; i ++) {
            for (int j = 0; j < n + 1; j ++) {
                f[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        
        f[0][0] = 0;
        for (int i = 1; i <= n * 2; i ++) {
            for (int j = 0; j <= Math.min(i, n); j ++) {
                if (i - j > n) continue;
                if (j > 0)
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + costs[i - 1][0]);
                if (i - 1 >= j)
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + costs[i - 1][1]);
                // System.out.println(i + " " + j + " " + f[i][j]);
            }
        }
        return f[n * 2][n];
    }
}

// Greedy

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int ans = 0;
        for (int i = 0; i < costs.length / 2; i ++)
            ans += costs[i][0] + costs[i + costs.length / 2][1];
        return ans;
    }
}