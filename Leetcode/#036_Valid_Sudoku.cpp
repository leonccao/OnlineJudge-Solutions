class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        bool box[9][9];
        bool row[9][9];
        bool col[9][9];
        for (int i = 0; i < 9; i ++)
            for (int j = 0; j < 9; j ++) {
                box[i][j] = false;
                row[i][j] = false;
                col[i][j] = false;
            }
        for (int i = 0; i < 9; i ++)
            for (int j = 0; j < 9; j ++) {
                int k = i / 3 * 3 + j / 3;
                if (board[i][j] == '.') continue;
                
                if (box[k][board[i][j] - '1'])
                    return false;
                box[k][board[i][j] - '1'] = true;
                // cout << 'A' << endl;
                
                if (row[i][board[i][j] - '1'])
                    return false;
                row[i][board[i][j] - '1'] = true;
                // cout << 'B' << endl;
                
                if (col[j][board[i][j] - '1'])
                    return false;
                col[j][board[i][j] - '1'] = true;
            }
        return true;      
    }
};