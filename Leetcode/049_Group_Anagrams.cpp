class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, multiset<string>> um;
        for (string s : strs) {
            string t = s;
            sort(t.begin(), t.end());
            um[t].insert(s);
        }
        vector<vector<string>> anagrams;
        for (auto m : um) {
            vector<string> anagram(m.second.begin(), m.second.end());
            anagrams.push_back(anagram);
        }
        return anagrams;
    }
};