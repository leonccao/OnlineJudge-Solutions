class Solution {
    public int countNeighbours(int x, int y, int[][] board) {
        int cnt = 0;
        for (int i = -1; i < 2; i ++)
            for (int j = -1; j < 2; j ++) {
                if (i == 0 && j == 0) continue;
                int dx = x + i;
                if (dx < 0 || dx == board.length) continue;
                int dy = y + j;
                if (dy < 0 || dy == board[0].length) continue;
                if ((board[dx][dy] & 1) == 1) cnt ++;
            }
        return cnt;
    }
    
    public void gameOfLife(int[][] board) {
        if (board.length == 0) return;
        for (int i = 0; i < board.length; i ++)
            for (int j = 0; j < board[0].length; j ++) {
                int nb = countNeighbours(i, j, board);
                if (board[i][j] == 1 && (nb == 2 || nb == 3))
                    board[i][j] = 3;
                if (board[i][j] == 0 && nb == 3)
                    board[i][j] = 2;
            }
        for (int i = 0; i < board.length; i ++)
            for (int j = 0; j < board[0].length; j ++)
                board[i][j] >>= 1;
    }
}