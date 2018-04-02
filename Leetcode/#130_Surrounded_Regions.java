class Solution {
    final static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    class Block {
        public int x, y;
        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public boolean invalid(int x, int y, int row, int col) {
        if (x <= 0) return true;
        if (y <= 0) return true;
        if (x >= row) return true;
        if (y >= col) return true;
        return false;
    }
    
    public void solve(char[][] board) {
        if (board.length == 0) return;
        
        int row = board.length + 1;
        int col = board[0].length + 1;
        boolean[][] visited = new boolean[row + 1][col + 1];
        Queue<Block> queue = new LinkedList<Block>();
        for (int i = 0; i <= row; i ++) {
            queue.offer(new Block(i, 0));
            queue.offer(new Block(i, col));
            visited[i][0] = visited[i][col] = true;
        }
        for (int j = 1; j < col; j ++) {
            queue.offer(new Block(0, j));
            queue.offer(new Block(row, j));
            visited[0][j] = visited[row][j] = true;
        }
        
        while (!queue.isEmpty()) {
            Block block = queue.poll();
            for (int mv = 0; mv < 4; mv ++) {
                int x = block.x + move[mv][0];
                int y = block.y + move[mv][1];
                if (invalid(x, y, row, col)) continue;
                if (board[x - 1][y - 1] == 'X') continue;
                if (visited[x][y]) continue;
                visited[x][y] = true;
                queue.offer(new Block(x, y));
            }
        }
        for (int i = 0; i < row - 1; i ++)
            for (int j = 0; j < col - 1; j ++)
                if (board[i][j] == 'O')
                    if (!visited[i + 1][j + 1])
                        board[i][j] = 'X';
    }
}