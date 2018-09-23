/*
### Corner cases
1. Some building may could not be reached
2. Some empty block may could not be reached

### Solutions
1. BFS
    - Time complexity: O(m^2 n^2)
    - Space complexity: O(mn)

### Bugs
1. `Map<String, Interger[][]>` the array should be exactly `Integer[][]`

### Test cases

*/
class Solution {
    
    class Block {
        int x, y;
        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    final static int[][] MV = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0) return -1;
        
        int[][] sum = new int[grid.length][grid[0].length];
        int[][] reach = new int[grid.length][grid[0].length];
        int cnt1 = 0;
        
        Queue<Block> queue = new LinkedList<Block>();
        for (int i = 0; i < grid.length; i ++)
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] != 1) continue;
                cnt1 ++;
                
                Block start = new Block(i, j);
                queue.add(start);
                int[][] dist = new int[grid.length][grid[0].length];
                for (int p = 0; p < grid.length; p ++)
                    for (int q = 0; q < grid[0].length; q ++)
                        dist[p][q] = Integer.MAX_VALUE;
                dist[i][j] = 0;
                
                while (!queue.isEmpty()) {
                    Block cur = queue.poll();
                    for (int[] mv : MV) {
                        int x = cur.x + mv[0];
                        int y = cur.y + mv[1];
                        if (x < 0 || x == grid.length) continue;
                        if (y < 0 || y == grid[0].length) continue;
                        if (grid[x][y] != 0 || dist[x][y] != Integer.MAX_VALUE) continue;
                        
                        dist[x][y] = dist[cur.x][cur.y] + 1;
                        sum[x][y] += dist[x][y];
                        reach[x][y] ++;
                        queue.add(new Block(x, y));
                    }
                }
            }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i ++)
            for (int j = 0; j < grid[0].length; j ++) {
                if (reach[i][j] < cnt1) continue;
                ans = Math.min(ans, sum[i][j]);
            }
        
        if (ans < Integer.MAX_VALUE) return ans;
        return -1;
    }
}