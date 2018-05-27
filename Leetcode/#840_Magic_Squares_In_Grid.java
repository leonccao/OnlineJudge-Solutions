class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length == 0) return 0;
        
        int ans = 0;
        for (int highI = 2; highI < grid.length; highI ++)
            NextLoop:
            for (int highJ = 2; highJ< grid.length; highJ ++) {
                int lowI = highI - 2;
                int lowJ = highJ - 2;
                int sum = grid[lowI][lowJ] + grid[lowI + 1][lowJ + 1] + grid[highI][highJ];
                if (sum != grid[lowI][highJ] + grid[lowI + 1][lowJ + 1] + grid[highI][lowJ])
                    continue;
                for (int i = lowI; i <= highI; i ++) {
                    int tmp = 0;
                    for (int j = lowJ; j <= highJ; j ++) {
                        if (grid[i][j] > 9) continue NextLoop;
                        if (grid[i][j] < 1) continue NextLoop;
                        tmp += grid[i][j];
                    }
                    if (tmp != sum) continue NextLoop;
                }
                for (int j = lowJ; j <= highJ; j ++) {
                    int tmp = 0;
                    for (int i = lowI; i <= highI; i ++)
                        tmp += grid[i][j];
                    if (tmp != sum) continue NextLoop;
                }
                ans ++;
            }
        return ans;
    }
}