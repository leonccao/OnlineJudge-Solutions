class Solution {
    static final int[][] MV = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    long MOD = 1000000000 + 7;
    
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sort = new int[m * n][3];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sort[index][0] = i;
                sort[index][1] = j;
                sort[index][2] = grid[i][j];
                index++;
            }
        }
        Arrays.sort(sort, (a, b) -> a[2] - b[2]);
        
        long[][] f = new long[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                f[i][j] = 1;
            }
        }
        long result = 0;
        for (int[] box : sort) {
            int x = box[0];
            int y = box[1];
            for (int[] mv : MV) {
                int nx = x + mv[0];
                int ny = y + mv[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] >= box[2]) {
                    continue;
                }
                f[x][y] = (f[x][y] + f[nx][ny]) % MOD;
            }
            result = (result + f[x][y]) % MOD;
        }
        return (int)result;
    }
}