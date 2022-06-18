class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        
        for (int j = 0; j < n; j++) {
            cost[0][j] = grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    cost[i][j] = Math.min(
                        cost[i][j],
                        cost[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]
                    );
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, cost[m - 1][j]);
        }
        return result;
    }
}