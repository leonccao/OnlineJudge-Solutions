class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) return "";
        string stand = strs[0];
        for (int i = 0; i < strs.size(); i ++)
            if (strs[i].size() < stand.size())
                stand = strs[i];
        
        int l = 0, r = stand.size() + 1;
        while (l < r - 1) {
            int middle = (l + r) / 2;
            if (check(middle, strs, stand)) l = middle;
            else r = middle;
        }
        return stand.assign(stand, 0, l);
    }
    
    bool check(int middle, vector<string>& strs, string stand) {
        for (int i = 0; i < strs.size(); i ++)
            for (int j = 0; j < middle; j ++)
                if (stand[j] != strs[i][j])
                    return false;
        return true;
    }
};