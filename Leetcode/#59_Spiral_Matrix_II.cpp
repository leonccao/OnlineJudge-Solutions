class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<int> blank;
        vector<vector<int>> matrix;
        for (int i = 0; i < n; i ++)
            blank.push_back(0);
        for (int i = 0; i < n; i ++)
            matrix.push_back(blank);
        
        int num = 0;
        for (int round = 0; round < (n + 1) / 2; round ++) {
            for (int i = round; i < n - round; i ++)
                matrix[round][i] = ++ num;
            for (int i = round + 1; i <= n - round - 1; i ++)
                matrix[i][n - round - 1] = ++ num;
            for (int i = n - round - 2; i >= round; i --)
                matrix[n - round - 1][i] = ++ num;
            for (int i = n - round - 2; i >= round + 1; i --)
                matrix[i][round] = ++ num;
        }
        return matrix;
    }
};