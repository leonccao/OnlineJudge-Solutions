class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> result;
        vector<string> solution;
        search(0, 0, 0, 0, n, solution, result);
        return result;
    }
    
    void search(int level, int ver, int left, int right, int n, vector<string>& solution, vector<vector<string>>& result) {
        if (level == n) {
            result.push_back(solution);
            return;
        }
        const int full = (1 << n) - 1;
        left = left << 1 & full;
        right = right >> 1;
        for (int i = 0; i < n; i ++) {
            int state = 1 << i;
            if (state & ver) continue;
            if (state & left) continue;
            if (state & right) continue;
            ver = ver | state;
            left = left | state;
            right = right | state;
            solution.push_back(makeStr(i, n));
            
            search(level + 1, ver, left, right, n, solution, result);
            
            solution.pop_back();
            ver = ver ^ state;
            left = left ^ state;
            right = right ^ state;
        }
    }
    
    string makeStr(int x, int n) {
        string s = "";
        for (int i = n - 1; i > x; i --) s += '.';
        s += 'Q';
        for (int i = x - 1; i >= 0; i --) s += '.';
        return s;
    }
};