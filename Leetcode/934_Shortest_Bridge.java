class Solution {
    private class Block {
        int x, y, dist;
        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Block(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        public String toString() {
            return x + " " + y;
        }
    }
    
    final static int[][] MV = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    public int shortestBridge(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        Queue<Block> queue = new LinkedList<>();
        OUTER_LOOP:
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++)
                if (A[i][j] == 1) {
                    queue.add(new Block(i, j));
                    break OUTER_LOOP;
                }
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Block cur = queue.poll();
            A[cur.x][cur.y] = 2;
            for (int[] mv : MV) {
                int x = cur.x + mv[0];
                int y = cur.y + mv[1];
                if (x < 0 || x == n || y < 0 || y == m) continue;
                if (A[x][y] != 1) continue;
                Block tmp = new Block(x, y);
                if (visited.contains(tmp.toString())) continue;
                queue.add(tmp);
                visited.add(tmp.toString());
            }
        }
        
        queue = new LinkedList<>();
        visited = new HashSet<>();
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++)
                if (A[i][j] == 1) {
                    Block tmp = new Block(i, j, 0);
                    queue.add(tmp);
                    visited.add(tmp.toString());
                }
        
        while (!queue.isEmpty()) {
            Block cur = queue.poll();
            for (int[] mv : MV) {
                int x = cur.x + mv[0];
                int y = cur.y + mv[1];
                if (x < 0 || x == n || y < 0 || y == m) continue;
                if (A[x][y] == 2) return cur.dist;
                if (A[x][y] == 1) continue;
                Block tmp = new Block(x, y, cur.dist + 1);
                if (visited.contains(tmp.toString())) continue;
                queue.add(tmp);
                visited.add(tmp.toString());
            }
        }
        return 0;
    }
}