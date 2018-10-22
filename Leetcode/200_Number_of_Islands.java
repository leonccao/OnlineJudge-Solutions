class Solution {
    final static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public void floodFill(int x, int y, char[][] grid) {
        grid[x][y] = '0';
        for (int[] mv : move) {
            int i = x + mv[0];
            if (i < 0 || i >= grid.length) continue;
            int j = y + mv[1];
            if (j < 0 || j >= grid[0].length) continue;
            if (grid[i][j] != '1') continue;
            floodFill(i, j, grid);
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i ++)
            for (int j = 0; j < grid[0].length; j ++)
                if (grid[i][j] == '1') {
                    ans ++;
                    floodFill(i, j, grid);
                }
        return ans;
    }
}