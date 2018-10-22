class Solution {
public:
    bool isMatch(string s, string p) {
        if (s == p) return true;
        if (s == ""  && p == "*") return true;
        if (s == "*" && p == "" ) return true;
        
        s = "@" + s;
        p = "@" + p;
        bool match[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i ++)
            for (int j = 0; j <= p.length(); j ++)
                match[i][j] = false;
        
        match[0][0] = true;
        for (int i = 1; i <= s.length(); i ++)
            if (s[i] == '*' && match[i - 1][0])
                    match[i][0] = true;
        for (int j = 1; j <= p.length(); j ++)
            if (p[j] == '*' && match[0][j - 1])
                    match[0][j] = true;
        for (int i = 1; i <= s.length(); i ++)
            for (int j = 1; j <= p.length(); j ++) {
                if (s[i] == p[j] && match[i - 1][j - 1]) {
                    match[i][j] = true;
                    continue;
                }
                if ((s[i] == '?' || p[j] == '?') && match[i - 1][j - 1]) {
                    match[i][j] = true;
                    continue;
                }
                 if (s[i] == '*' || p[j] == '*') 
                    if (match[i - 1][j] || match[i][j - 1] || match[i - 1][j - 1]) {
                        match[i][j] = true;
                        continue;
                    }
            }
                
        return match[s.length()][p.length()];
    }
};