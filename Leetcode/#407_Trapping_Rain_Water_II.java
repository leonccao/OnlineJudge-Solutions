class Solution {
    private class Block {
        private int x, y, hold;
        public Block(int x, int y, int hold) {
            this.x = x;
            this.y = y;
            this.hold = hold;
        }
    }
    
    final static int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0) return 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        
        PriorityQueue<Block> heap = new PriorityQueue<Block>(
            new Comparator<Block>() {
                public int compare(Block a, Block b) {
                    return a.hold - b.hold;
                }
            }    
        );
        
        for (int i = 0; i < row; i ++) {
            heap.add(new Block(i, -1,  -1));
            heap.add(new Block(i, col, -1));
        }
        for (int j = 0; j < col; j ++) {
            heap.add(new Block(-1,  j, -1));
            heap.add(new Block(row, j, -1));
        }
        
        boolean[][] visited = new boolean[row][col];
        int ans = 0;
        while (!heap.isEmpty()) {
            Block cur = heap.poll();
            for (int[] mv : move) {
                int nx = cur.x + mv[0];
                int ny = cur.y + mv[1];
                if (nx < 0 || nx >= row) continue;
                if (ny < 0 || ny >= col) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                
                if (cur.hold > heightMap[nx][ny]) {
                    ans += cur.hold - heightMap[nx][ny];
                    heap.add(new Block(nx, ny, cur.hold));
                } else heap.add(new Block(nx, ny, heightMap[nx][ny]));
            }
        }
        return ans;
    }
}