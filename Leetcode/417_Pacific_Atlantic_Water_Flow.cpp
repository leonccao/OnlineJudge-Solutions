class Solution {    
private:
    const vector<pair<int, int>> MV = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    void bfs(queue<pair<int, int>> &q, vector<vector<bool>> &visited, vector<vector<int>> &heights) {
        int m = heights.size();
        int n = heights[0].size();
        while (!q.empty()) {
            auto cur = q.front();
            q.pop();
            for (const auto mv : MV) {
                int x = cur.first + mv.first;
                int y = cur.second + mv.second;
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                if (heights[x][y] < heights[cur.first][cur.second]) {
                    continue;
                }
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    q.push({x, y});
                }
            }
        }
    }
    
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int m = heights.size();
        int n = heights[0].size();
        vector<vector<bool>> atl(m, vector<bool>(n, false)); 
        vector<vector<bool>> pac(m, vector<bool>(n, false));
        
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            int x = m - 1, y = i;
            atl[x][y] = true;
            q.push({x, y});
        }
        for (int i = 0; i < m - 1; i++) {
            int x = i, y = n - 1;
            atl[x][y] = true;
            q.push({x, y});
        }
        bfs(q, atl, heights);
        
        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            pac[x][y] = true;
            q.push({x, y});
        }
        for (int i = 1; i < m; i++) {
            int x = i, y = 0;
            pac[x][y] = true;
            q.push({x, y});
        }
        bfs(q, pac, heights);
        
        vector<vector<int>> ans;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atl[i][j] && pac[i][j]) {
                    ans.push_back({i, j});
                }
            }
        }
        return ans;
    }
};