class Solution {
    private class Pos{
        private int x, y, status;
        public Pos(int x, int y, int status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }
    
    final static int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        
        Pos start = null;
        int K = 0;
        for (int i = 0; i < row; i ++) {
            char[] column = grid[i].toCharArray();
            for (int j = 0; j < col; j ++) {
                char ch = column[j];
                if (ch == '@')
                    start = new Pos(i, j, 0);
                else if (ch <= 'f' && ch >= 'a')
                    K = Math.max(K, ch - 'a' + 1);
            }
        }
        
        int limit = 1 << K;
        int[][][] dist = new int[row][col][limit + 1];
        for (int i = 0; i < row; i ++)
            for (int j = 0; j < col; j ++)
                for (int k = 0; k < limit; k ++)
                    dist[i][j][k] = Integer.MAX_VALUE - 1;
        dist[start.x][start.y][start.status] = 0;
        
        Queue<Pos> queue = new LinkedList<Pos>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            int curDist = dist[cur.x][cur.y][cur.status];
            for (int[] mv : move) {
                int x = cur.x + mv[0];
                int y = cur.y + mv[1];
                if (x < 0 || x >= row) continue;
                if (y < 0 || y >= col) continue;
                
                char ch = grid[x].charAt(y);
                int status = cur.status;
                if (ch == '#') continue;
                if (ch >= 'A' && ch <= 'F') {
                    int tmp = ch - 'A';
                    if ((status & (1 << tmp)) == 0) continue;
                }
                if (ch >= 'a' && ch <= 'f') {
                    int tmp = ch - 'a';
                    status |= (1 << tmp);
                }
                
                if (curDist + 1 < dist[x][y][status]) {
                    dist[x][y][status] = curDist + 1;
                    queue.add(new Pos(x, y, status));
                    if (status == limit - 1)
                        return curDist + 1;
                }
            }
        }
        return -1;
    }
}