class Solution {
public:
    bool box[9][9];
    bool row[9][9];
    bool col[9][9];
    vector<vector<char>> result;
    void solveSudoku(vector<vector<char>>& board) {
        result = board;
        for (int i = 0; i < 9; i ++)
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') continue;
                int k = i / 3 * 3 + j / 3;
                box[k][board[i][j] - '1'] = true;
                row[i][board[i][j] - '1'] = true;
                col[j][board[i][j] - '1'] = true;
            }
        fillIn(0, 0);   
        board = result;
    }
    bool fillIn(int x, int y) {
        if (y == 9) {x += 1; y = 0;}
        if (x == 9) return true;
        
        if (result[x][y] != '.')
            return fillIn(x, y + 1);
        
        int k = x / 3 * 3 + y / 3;
        for (int i = 0; i < 9; i ++) {
            if (box[k][i]) continue;
            if (row[x][i]) continue;
            if (col[y][i]) continue;
            result[x][y] = i + '1';
            box[k][i] = true;
            row[x][i] = true;
            col[y][i] = true;
            
            if (fillIn(x, y + 1)) return true;
            
            result[x][y] = '.';
            box[k][i] = false;
            row[x][i] = false;
            col[y][i] = false;
        }
        
        return false;
    }
};