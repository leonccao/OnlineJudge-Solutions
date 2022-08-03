class Solution {
private:
    bool isShip(vector<vector<char>>& board, int x, int y) {
        return (x == 0 || board[x - 1][y] == '.')
           && (y == 0 || board[x][y - 1] == '.');
    }
    
public:
    int countBattleships(vector<vector<char>>& board) {
        int result = 0;
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if (board[i][j] == 'X' && isShip(board, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }
};