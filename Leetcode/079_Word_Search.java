class Solution {
    
    final static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public boolean valid(int x, int y, int r, int c) {
        if (x < 0 || x >= r) return false;
        if (y < 0 || y >= c) return false;
        return true;
    }
    
    public boolean DFS(char[][] board, boolean[][] visited, int x, int y, String word, int now) {
        if (board[x][y] != word.charAt(now))
            return false;
        
        visited[x][y] = true;
        if (now == word.length() - 1)
            return true;
        
        for (int mv = 0; mv < 4; mv ++) {
            int i = x + move[mv][0];
            int j = y + move[mv][1];
            if (!valid(i, j, board.length, board[0].length))
                continue;
            if (visited[i][j]) continue;
            if (DFS(board, visited, i, j, word, now + 1))
                return true;
        }
        visited[x][y] = false;
        
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        if (word.equals("") || word.length() == 0)
            return false;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++)
            for (int j = 0; j < board[0].length; j ++)
                if (DFS(board, visited, i, j, word, 0))
                    return true;
        return false;
    }
}