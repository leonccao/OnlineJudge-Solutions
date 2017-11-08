class Solution {
public:
    bool isValid(string s) {
        vector<int> bracket;
        for (int i = 0; i < s.size(); i ++)
            switch (s[i]) {
                case '(': bracket.push_back(1); break;
                case '[': bracket.push_back(2); break;
                case '{': bracket.push_back(3); break;
                case ')': bracket.push_back(4); break;
                case ']': bracket.push_back(5); break;
                case '}': bracket.push_back(6); break;
            }
            
        stack<int> match;
        for (int i = 0; i < bracket.size(); i ++) {
            if (bracket[i] < 4) match.push(bracket[i]);
            else if (match.empty()) return false;
            else if (bracket[i] - match.top() == 3) match.pop();
            else return false;
        }
        if (!match.empty()) return false;
        
        return true;
        
    }
};