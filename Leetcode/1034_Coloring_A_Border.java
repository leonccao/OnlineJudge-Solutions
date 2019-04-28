class Solution {
    final static int[][] MV = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    private class Point {
        int x, y;
        String sign = "";
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            sign = "" + x + "," + y;
        }
    }
    
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        Queue<Point> queue = new LinkedList<>();
        Point start = new Point(r0, c0);
        queue.offer(start);
        int type = grid[r0][c0];
        
        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                res[i][j] = grid[i][j];
            }
        }
        
        Set<String> set = new HashSet<>();
        set.add(start.sign);
        
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            boolean border = false;
            
            for (int[] mv : MV) {
                int x = cur.x + mv[0];
                int y = cur.y + mv[1];
                if (x < 0 || x == grid.length || y < 0 || y == grid[0].length) {
                    border = true;
                    continue;
                }
                if (grid[x][y] != type) {
                    border = true;
                    continue;
                }
                Point nxt = new Point(x, y);
                if (set.contains(nxt.sign)) continue;
                set.add(nxt.sign);
                queue.offer(nxt);
            }
            if (border) {
                res[cur.x][cur.y] = color;
            }
        }
        return res;
    }
}