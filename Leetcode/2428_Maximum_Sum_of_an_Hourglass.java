class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int sum = grid[i][j];
                for (int k = j - 1; k <= j + 1; k++) {
                    sum += grid[i - 1][k];
                    sum += grid[i + 1][k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}