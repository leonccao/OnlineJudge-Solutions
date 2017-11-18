class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> result;
        if (matrix.empty()) return result;
        int m = matrix.size();
        int n = matrix[0].size();
        for (int round = 0; round < n; round ++) {
            for (int i = round; i < n - round; i ++)
                result.push_back(matrix[round][i]);
            if (result.size() == m * n) break;
            for (int i = round + 1; i <= m - round - 1; i ++)
                result.push_back(matrix[i][n - round - 1]);
            if (result.size() == m * n) break;
            for (int i = n - round - 2; i >= round; i --)
                result.push_back(matrix[m - round - 1][i]);
            if (result.size() == m * n) break;
            for (int i = m - round - 2; i >= round + 1; i --)
                result.push_back(matrix[i][round]);
            if (result.size() == m * n) break;
        }
        return result;
    }
};