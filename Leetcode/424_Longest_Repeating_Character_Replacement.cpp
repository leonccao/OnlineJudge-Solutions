class Solution {
public:
    int characterReplacement(string s, int k) {
        unordered_map<int, int> count;
        int maxFreq = 0, start = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            maxFreq = max(maxFreq, ++count[s[i]]);
            if ((i - start + 1) - maxFreq > k) {
                count[s[start++]]--;
                maxFreq = 0;
                for (auto element : count) {
                    maxFreq = max(maxFreq, element.second);
                }
            } else {
                result = max(result, i - start + 1);
            }
        }
        return result;
    }
};