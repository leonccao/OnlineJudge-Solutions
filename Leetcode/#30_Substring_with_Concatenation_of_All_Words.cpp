class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        vector<int> result;
        int len = words[0].size();
        if (s.size() < words.size() * len)
            return result;
        
        unordered_map<string, int> counts;
        for (string word : words)
            counts[word] ++;
            
        for (int i = 0; i <= s.size() - words.size() * len; i ++) {
            unordered_map<string, int> found;
            int j;
            for (j = 0; j < words.size(); j ++) {
                string word = s.substr(i + j * len, len);
                if (counts.find(word) != counts.end()) {
                    found[word] ++;
                    if (found[word] > counts[word])
                        break;
                } else break;
            }
            if (j == words.size()) 
                result.push_back(i);
        }
        return result;
    }
};