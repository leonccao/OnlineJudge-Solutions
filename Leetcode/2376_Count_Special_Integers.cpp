class Solution {
private:
    string s;
    int f[11][1024][2][2];
    
    int dfs(int index, int mask, int isExact, int isValid) {
        if (f[index][mask][isExact][isValid] >= 0) {
            return f[index][mask][isExact][isValid];
        }
        if (index == s.length()) {
            return f[index][mask][isExact][isValid] = isValid;
        }
        f[index][mask][isExact][isValid] = 0;
        if (!isValid) {
            f[index][mask][isExact][isValid] += dfs(index + 1, mask, 0, 0);
        }
        int limit = s.at(index) - '0';
        for (int digit = (1 - isValid); digit < 10; digit++) {
            if (mask & (1 << digit)) {
                continue;
            }
            if (isExact && (digit > limit)) {
                break;
            }
            f[index][mask][isExact][isValid] += dfs(index + 1, mask | (1 << digit), isExact & (digit == limit), 1);
        }
        return f[index][mask][isExact][isValid];
    }
    
public:
    int countSpecialNumbers(int n) {
        s = to_string(n);
        memset(f, -1, sizeof(f));
        return dfs(0, 0, 1, 0);
    }
};