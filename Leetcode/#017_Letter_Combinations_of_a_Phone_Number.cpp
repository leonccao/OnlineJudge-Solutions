class Solution {
public:

    const string alphabet[8] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    vector<string> result;
    
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) return result;
        build(digits, 0, "");
        return result;
    }
    
    void build(string digits, int level, string gotS) {
        if (level == digits.size()) {
            result.push_back(gotS);
            return;
        }
        int num = digits[level] - '2';
        for (int i = 0; i < alphabet[num].size(); i ++) {
            string gotSC = gotS + alphabet[num][i];
            build(digits, level + 1, gotSC);
        }
    }
};