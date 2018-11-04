class Solution {
public:
    vector<int> movesToStamp(string stamp, string target) {
        vector<int> rec;
        while (true) {
            bool match = false;
            for (int i = 0; i < target.length() - stamp.length() + 1; i ++) {
                for (int j = 0; j < stamp.length(); j ++) {
                    if (target[i + j] == '?') continue;
                    match = true;
                    if (target[i + j] != stamp[j]) {
                        match = false; break;
                    }
                }
                if (!match) continue;
                rec.push_back(i);
                for (int j = 0; j < stamp.length(); j ++)
                    target[i + j] = '?';
                break;
            }
            if (!match) break;
        }
        for (int i = 0; i < target.length(); i ++)
            if (target[i] != '?')
                return vector<int>();
        reverse(rec.begin(), rec.end());
        return rec;
    }
};