class Solution {
    
    int m, n;
    
    class Block {
        int x, y;
        Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return x + " " + y;
        }
    }
    
    final static int[][] MV = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int color = -1;
        Set<String> visited = new HashSet<String>();
        Queue<Block> queue = new LinkedList<Block>();
        //Map<Integer, Integer> pm = new HashMap<Integer, Integer>();
        int pm = 0;
        for (int i = 0; i < m; i ++)
        for (int j = 0; j < n; j ++) {
            if (grid[i][j] == 0) continue;
            Block tmp = new Block(i, j);
            if (visited.contains(tmp.toString())) continue;
            
            color ++;
            visited.add(tmp.toString());
            queue.add(tmp);
            while (!queue.isEmpty()) {
                Block cur = queue.poll();
                int cnt = 0;
                if (cur.x == 0) cnt ++;
                if (cur.x == m - 1) cnt ++;
                if (cur.y == 0) cnt ++;
                if (cur.y == n - 1) cnt ++;
                //pm.put(color, pm.getOrDefault(color, 0) + cnt);
                pm += cnt;
                
                for (int[] mv : MV) {
                    int x = cur.x + mv[0];
                    int y = cur.y + mv[1];
                    if (x < 0 || x == m) continue;
                    if (y < 0 || y == n) continue;
                    if (grid[x][y] == 0) {
                        // pm.put(color, pm.getOrDefault(color, 0) + 1);
                        pm ++;
                        continue;
                    }
                    tmp = new Block(x, y);
                    if (visited.contains(tmp.toString())) continue;
                    visited.add(tmp.toString());
                    queue.add(tmp);
                }
            }
            break;
        }
        
        /*
        int ans = 0;
        for (int key : pm.keySet()) {
            System.out.println(key + " " + pm.get(key));
            ans = pm.get(key);
        }
        
        return ans;
        */
        return pm;
    }
}