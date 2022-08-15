class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int m = n - 2;
        int[][] res = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int x = i + 1, y = j + 1;
                int max = grid[x][y];
                for (int ii = -1; ii < 2; ii++) {
                    for (int jj = -1; jj < 2; jj++) {
                        int xx = x + ii, yy = y + jj;
                        max = Math.max(max, grid[xx][yy]);
                    }
                }
                res[i][j] = max;
            }
        }
        return res;
    }
}