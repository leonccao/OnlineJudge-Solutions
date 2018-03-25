class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid.length == 0) return 0;
        int[] mr = new int[grid.length];
        int[] mc = new int[grid[0].length];
        for (int i = 0; i < grid.length; i ++)
            for (int j = 0; j < grid[0].length; j ++) {
                mr[i] = Math.max(mr[i], grid[i][j]);
                mc[j] = Math.max(mc[j], grid[i][j]);
            }
        
        int result = 0;
        for (int i = 0; i < grid.length; i ++)
            for (int j = 0; j < grid[0].length; j ++) {
                int tmp = Math.min(mr[i], mc[j]) - grid[i][j];
                if (tmp > 0) result += tmp;
            }
        return result;
    }
}