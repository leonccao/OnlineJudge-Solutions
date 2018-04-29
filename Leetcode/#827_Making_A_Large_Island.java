class Solution {
    final static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public void floodfill(int x, int y, int color, int[][] grid) {
        grid[x][y] = color;
        for (int[] mv : move) {
            int i = x + mv[0];
            int j = y + mv[1];
            if (i < 0 || i == grid.length) continue;
            if (j < 0 || j == grid[0].length) continue;
            if (grid[i][j] != 1) continue;
            floodfill(i, j, color, grid);
        }
    }
    
    public int largestIsland(int[][] grid) {
        if (grid.length < 1) return 0;
        
        int color = 1;
        for (int i = 0; i < grid.length; i ++)
            for (int j = 0; j < grid[0].length; j ++)
                if (grid[i][j] == 1)
                    floodfill(i, j, ++ color, grid);
        
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 2; i <= color; i ++)
            map.put(i, 0);
        
        for (int i = 0; i < grid.length; i ++)
            for (int j = 0; j < grid[0].length; j ++)
                if (grid[i][j] > 1) {
                    int clr = grid[i][j];
                    map.put(clr, map.get(clr) + 1);
                }
        for (int key : map.keySet())
            ans = Math.max(ans, map.get(key));
        
        for (int i = 0; i < grid.length; i ++)
            for (int j = 0; j < grid[0].length; j ++)
                if (grid[i][j] == 0) {
                    List<Integer> ngb = new LinkedList<Integer>();
                    int tmp = 1;
                    for (int[] mv : move) {
                        int x = i + mv[0];
                        int y = j + mv[1];
                        
                        if (x < 0 || x == grid.length) continue;
                        if (y < 0 || y == grid[0].length) continue;
                        if (grid[x][y] < 2) continue;
                        
                        int clr = grid[x][y];
                        
                        if (ngb.contains(clr)) continue;
                        ngb.add(clr);
                        tmp += map.get(clr);
                    }   
                    ans = Math.max(ans, tmp);
                }
        return ans;
    }
}