class Solution {
public:
    int longestValidParentheses(string s) {
        if (s.empty()) return 0;
        vector<int> f(s.size(), 0);
        
        for (int i = 1; i < s.size(); i ++)
            if (s[i - 1] == '(' && s[i] == ')')
                f[i] = 2;
                
        for (int i = 3; i < s.size(); i ++) {
            int tmp = 0;
            if (s[i] == ')' && s[i - f[i - 1] - 1] == '(')
                tmp = f[i - 1] + 2;
            if (s[i] == ')' && s[i - f[i - 1] - 1] == '(' && i - f[i - 1] - 1 > 0)
                tmp += f[i - f[i - 1] - 2];
            f[i] = max(f[i], tmp);
            
            if (s[i - 1] == '(' && s[i] == ')')
                if (f[i - 2] + 2 > f[i])
                    f[i] = f[i - 2] + 2;
        }
        
        int result = 0;
        for (int i = 0; i < s.size(); i ++)
            result = max(result, f[i]);
        return result;
    }
};