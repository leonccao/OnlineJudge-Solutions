class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (!s.size()) return 0;
        vector<int> latest;
        int prev[256];
        for (int i = 0; i < 256; i ++)
            prev[i] = -1;
        for (int i = 0; i < s.size(); i ++) {
            latest.push_back(prev[s[i]]);
            prev[s[i]] = i;
        }
        
        int result = 0;
        int pointer = 0;
        for (int i = 0; i < s.size(); i++) {
            if (latest[i] >= pointer)
                pointer = latest[i] + 1;
            result = max(result, i - pointer + 1);
        }
        return result;
    }
};