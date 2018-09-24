class Solution {
    class Block {
        int x, y;
        Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    final static int[][] MV = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        
        Queue<Block> queue = new LinkedList<Block>();
        for (int i = 0; i < rooms.length; i ++)
            for (int j = 0; j < rooms[0].length; j ++)
                if (rooms[i][j] == 0)
                    queue.add(new Block(i, j));
        
        while (!queue.isEmpty()) {
            Block cur = queue.poll();
            for (int[] mv : MV) {
                int x = cur.x + mv[0];
                int y = cur.y + mv[1];
                if (x < 0 || x == rooms.length) continue;
                if (y < 0 || y == rooms[0].length) continue;
                if (rooms[x][y] != Integer.MAX_VALUE) continue;
                rooms[x][y] = rooms[cur.x][cur.y] + 1;
                queue.add(new Block(x, y));
            }
        }
    }
}