class Solution {
    public boolean validTicTacToe(String[] board) {
        int nx = 0, no = 0;
        for (String c : board)
            for (int i = 0; i < c.length(); i ++) {
                if (c.charAt(i) == 'X') nx ++;
                if (c.charAt(i) == 'O') no ++;
            }
        if (!(nx == no || nx - no == 1)) return false;
        if (check('X', board) && (nx == no || check('O', board))) return false;
        if (check('O', board) && (nx != no)) return false;
        return true;
    }
    
    public boolean check(char ch, String[] board) {
        for (String c : board)
            if (c.charAt(0) == ch && c.charAt(1) == ch && c.charAt(2) == ch)
                return true;
        for (int i = 0; i < 3; i ++)
            if (board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch)
                return true;
        if (board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch)
            return true;
        if (board[2].charAt(0) == ch && board[1].charAt(1) == ch && board[0].charAt(2) == ch)
            return true;
        return false;
    }
}