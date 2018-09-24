/*
### Corner cases

### Solution
1. Use rows[], cols[], dig and ndig to store number of checkers. If it is player 1 playing, num ++; Otherwise, num --. When abs(num) == n, game is over. 

*/
class TicTacToe {

    int[] rows;
    int[] cols;
    int[] digs;
    int num;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        digs = new int[2];
        num = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int tmp = player == 1 ? 1 : -1;
        rows[row] += tmp;
        cols[col] += tmp;
        if (row == col) digs[0] += tmp;
        if (row + col == num - 1) digs[1] += tmp;
        if (Math.abs(rows[row]) == num ||
            Math.abs(cols[col]) == num ||
            Math.abs(digs[0])   == num ||
            Math.abs(digs[1])   == num)
                return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */