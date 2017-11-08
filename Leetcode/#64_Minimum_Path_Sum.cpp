class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        vector<vector<int>> f = grid;
        int m = grid.size();
        int n = grid[0].size();
        f[0][0] = grid[0][0];
        
        for (int i = 0; i < m; i ++)
            for (int j = 0; j < n; j ++) {
                if (i + j == 0) continue;
                
                int a, b;
                if (i) a = f[i - 1][j];
                else a = 12345678;
                if (j) b = f[i][j - 1];
                else b = 12345678;
                f[i][j] = min(a, b) + grid[i][j];
            }
        
        return f[m - 1][n - 1];
    }
};