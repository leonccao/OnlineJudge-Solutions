class Solution {
public:
    vector<string> result;

    vector<string> generateParenthesis(int n) {
        build("", n, n);
        return result;
    }
    
    void build(string s, int l, int r) {
        if (!check(s)) return;
        if ((l | r) == 0) {
            if (check(s) == 2)
                result.push_back(s);
            return;
        }
        if (l) build(s + '(', l - 1, r);
        if (r) build(s + ')', l, r - 1);
        return;
    }
    
    int check(string s) {
        stack<char> match;
        for (int i = 0; i < s.size(); i ++) {
            if (s[i] == '(') match.push('(');
            else if (match.empty()) return 0;
            else match.pop();
        }
        if(match.empty()) return 2;
        return 1;
    }
};