class Solution {
    final static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public boolean invalid(int x, int y, int row, int col) {
        if (x < 0 || x >= row) return true;
        if (y < 0 || y == col) return true;
        return false;
    }
    
    class Brick {
        public int x, y;
        Brick(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        Queue<Brick> q = new LinkedList<Brick>();
        
        int row = grid.length, col = grid[0].length;
        int[][] conn = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < hits.length; i ++) {
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] != 1) continue;
            grid[x][y] = i + 2;
        }
        
        for (int i = 0; i < col; i ++) {
            if (grid[0][i] == 0) continue;
            if (grid[0][i] == 1)
                conn[0][i] = Integer.MAX_VALUE;
            else conn[0][i] = grid[0][i];
            q.add(new Brick(0, i));
            visited[0][i] = true;
        }
        
        Brick b;
        while ((b = q.poll()) != null) {
            for (int mv = 0; mv < 4; mv ++) {
                int x = b.x + move[mv][0];
                int y = b.y + move[mv][1];
                if (invalid(x, y, row, col)) continue;
                
                if (grid[x][y] == 0) continue;
                if (conn[x][y] >= conn[b.x][b.y]) continue;
                
                conn[x][y] = conn[b.x][b.y];
                if (grid[x][y] > 1)
                    conn[x][y] = Math.min(conn[x][y], grid[x][y]);
                if (visited[x][y]) continue;
                q.add(new Brick(x, y));
                visited[x][y] = true;
            }
            visited[b.x][b.y] = false;
        }
        
        int[] result = new int[hits.length];
        for (int i = 0; i < row; i ++)
            for (int j = 0; j < col; j ++) {
                if (grid[i][j] == 0) continue;
                if (grid[i][j] == conn[i][j]) continue;
                if (conn[i][j] - 2 < hits.length)
                    result[conn[i][j] - 2] ++;
            }     
        return result;
    }
}