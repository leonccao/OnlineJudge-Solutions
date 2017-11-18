class Solution {
public:
    int totalNQueens(int n) {
        int result = 0;
        search(0, 0, 0, 0, n, result);
        return result;
    }
    
    void search(int level, int ver, int left, int right, int n, int& result) {
        if (level == n) {
            result ++;
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
            
            search(level + 1, ver, left, right, n, result);
            
            ver = ver ^ state;
            left = left ^ state;
            right = right ^ state;
        }
    }
};